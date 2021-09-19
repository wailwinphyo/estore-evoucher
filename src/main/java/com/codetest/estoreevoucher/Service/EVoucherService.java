package com.codetest.estoreevoucher.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.codetest.estoreevoucher.Entity.BuyerInfoEntity;
import com.codetest.estoreevoucher.Entity.EVoucherEntity;
import com.codetest.estoreevoucher.Entity.PaymentMethod;
import com.codetest.estoreevoucher.Entity.PromoCodeVoucher;
import com.codetest.estoreevoucher.Entity.TransactionHistory;
import com.codetest.estoreevoucher.Entity.UserEntity;
import com.codetest.estoreevoucher.Enum.ActiveStatus;
import com.codetest.estoreevoucher.Enum.CardType;
import com.codetest.estoreevoucher.Enum.PurchaseStatus;
import com.codetest.estoreevoucher.Enum.UsedStatus;
import com.codetest.estoreevoucher.Exception.InvalidPayloadException;
import com.codetest.estoreevoucher.Exception.InvalidPaymentException;
import com.codetest.estoreevoucher.Model.EvoucherCheckoutDTO;
import com.codetest.estoreevoucher.Model.EvoucherDTO;
import com.codetest.estoreevoucher.Model.PromoCodeVoucherDTO;
import com.codetest.estoreevoucher.Repository.BuyerInfoRepository;
import com.codetest.estoreevoucher.Repository.EvoucherRepository;
import com.codetest.estoreevoucher.Repository.PromoCodeVoucherRepo;
import com.codetest.estoreevoucher.Repository.TransactionHistoryRepo;
import com.codetest.estoreevoucher.Utilities.CommonUtil;
import com.codetest.estoreevoucher.Utilities.FileUploadUtil;

import ma.glasnost.orika.MapperFacade;

@Service
public class EVoucherService {

	@Autowired
	MapperFacade mapper;
	
	@Autowired
	EvoucherRepository evoucherRepo;
	
	@Autowired
	BuyerInfoRepository buyerInfoRepo;
	
	@Autowired
	TransactionHistoryRepo transactionRepo;
	
	@Autowired
	PromoCodeVoucherRepo promocodeRepo;
	
	@Value("${evoucher.upload-dir:evoucher-photos}")
	private String uploadDir;
	
	private final String voucherDir = "/vouchers";
	
	private final String promocodeDir = "/QRpromocodes";
	
	public void createEvoucher(EvoucherDTO evoucher) throws Exception {
		EVoucherEntity evoucherEntity = mapper.map(evoucher, EVoucherEntity.class);
		evoucherEntity.setStatus(ActiveStatus.ACTIVE.toString());
		evoucherEntity.setImageUrl(StoreImage(uploadDir + voucherDir, evoucher.getImage()));
		evoucherEntity.setPaymentMethod(new PaymentMethod(evoucher.getPaymentMethodId()));
		evoucherRepo.save(evoucherEntity);
	}

	private String StoreImage(String dir, MultipartFile image) throws Exception {
		String fileName = StringUtils.cleanPath(image.getOriginalFilename());
		String fileNameUUID = String.format("%s%s", UUID.randomUUID().toString(), fileName.substring(fileName.lastIndexOf(".")));
		FileUploadUtil.saveFile(dir, fileNameUUID, image);
		return dir + "/" + fileNameUUID;
	}

	public EvoucherDTO retrieveEVoucher(long id) {
		EVoucherEntity evoucherEntity = evoucherRepo.getById(id);
		return mapper.map(evoucherEntity, EvoucherDTO.class);
	}

	public void updateEVoucher(EvoucherDTO evoucherdto) throws Exception {
		EVoucherEntity evoucherEntity = mapper.map(evoucherdto, EVoucherEntity.class);
		evoucherEntity.setStatus(ActiveStatus.ACTIVE.toString());
		evoucherEntity.setPaymentMethod(new PaymentMethod(evoucherdto.getPaymentMethodId()));
		
		if(evoucherdto.getImage() != null && evoucherdto.getImage().getSize() > 0) {
			evoucherEntity.setImageUrl(StoreImage(uploadDir + voucherDir, evoucherdto.getImage()));	
		}
		
		evoucherRepo.save(evoucherEntity);
	}

	public List<EvoucherDTO> retrieveEVouchers() {
		List<EVoucherEntity> evoucher_list = evoucherRepo.findAll();
		return mapper.mapAsList(evoucher_list, EvoucherDTO.class);
	}

	public EvoucherDTO updateEvoucherStatus(long id, String status) {
		EVoucherEntity evoucher = evoucherRepo.getById(id);
		evoucher.setStatus(status);
		evoucherRepo.save(evoucher);
		return mapper.map(evoucher, EvoucherDTO.class);
	}

	public BuyerInfoEntity purchaseEvocher(EvoucherCheckoutDTO checkoutDTO) throws InvalidPayloadException {
		UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Optional<EVoucherEntity> evoucherOptional = evoucherRepo.findById(checkoutDTO.getEvoucherId());
		
		if(evoucherOptional.isEmpty())
			throw new InvalidPayloadException("Voucher not found");
		
		EVoucherEntity evoucher = evoucherOptional.get();
		
		if(evoucher.getQuantity() - checkoutDTO.getQuantity() < 0)
			throw new InvalidPayloadException("Invalid Quantity");

		evoucher.setQuantity(evoucher.getQuantity() - checkoutDTO.getQuantity());
		evoucherRepo.save(evoucher);
		
		double amount = (evoucher.getAmount() * checkoutDTO.getQuantity());
		if(checkoutDTO.getPaymentMethod() == evoucher.getPaymentMethod().getId()) {
			amount = amount - (amount * (evoucher.getPaymentDiscount()/100));
		}
		BuyerInfoEntity buyerinfo = mapper.map(checkoutDTO, BuyerInfoEntity.class);
		buyerinfo.setUser(user);
		buyerinfo.setAmount(amount);
		buyerinfo.setStatus(PurchaseStatus.PENDING.toString());
		buyerinfo.setEvoucher(evoucher);
		buyerinfo.setCreatedDateTime(new Date());
		buyerInfoRepo.save(buyerinfo);
		
		return buyerinfo;
	}

	public void submitPayment(EvoucherCheckoutDTO checkoutDTO, BuyerInfoEntity buyinfo) throws InvalidPaymentException {

		if((!CardType.isValid(checkoutDTO.getCreditCardNumber())))
			throw new InvalidPaymentException("Invalid Payment");
		
		TransactionHistory tranHist = new TransactionHistory(0, new Date(), buyinfo.getAmount());
		transactionRepo.save(tranHist);
		buyinfo.setTransactionHistory(tranHist);
		buyinfo.setStatus(PurchaseStatus.PAID.toString());
		buyerInfoRepo.save(buyinfo);
	}

	public List<PromoCodeVoucherDTO> retrievePurchaseHistory(UserEntity user) {
		List<PromoCodeVoucher> vouchers = promocodeRepo.findByUser(user);
		List<PromoCodeVoucherDTO> voucherDTOs = mapper.mapAsList(vouchers, PromoCodeVoucherDTO.class);
		return voucherDTOs;
	}

	public void generatePromocode(BuyerInfoEntity buyinfo) throws Exception {
		List<PromoCodeVoucher> existingPromoCodes = promocodeRepo.findAll();
		List<String> existingPromocodeStr = existingPromoCodes.stream().map(x -> x.getPromocode()).collect(Collectors.toList());
		Set<String> promoCodes = CommonUtil.generatePromocodes(existingPromocodeStr, buyinfo.getQuantity());
		for(String promoCode : promoCodes) {
			PromoCodeVoucher voucher = new PromoCodeVoucher();
			voucher.setBuyerInfo(buyinfo);
			voucher.setUser(buyinfo.getUser());
			voucher.setPromocode(promoCode);
			voucher.setUseStatus(UsedStatus.UNUSE.toString());
			voucher.setQrCodeUrl(FileUploadUtil.generateNStoreQRCodeImage(uploadDir + promocodeDir, promoCode));
			promocodeRepo.save(voucher);
		}
	}

	public PromoCodeVoucherDTO checkPromocode(String promocode) {
		PromoCodeVoucher voucher = promocodeRepo.findByPromocode(promocode);
		PromoCodeVoucherDTO voucherDto = mapper.map(voucher, PromoCodeVoucherDTO.class);
		return voucherDto;
	}

}
