package com.codetest.estoreevoucher.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.estoreevoucher.Entity.BuyerInfoEntity;
import com.codetest.estoreevoucher.Entity.PaymentMethod;
import com.codetest.estoreevoucher.Entity.UserEntity;
import com.codetest.estoreevoucher.Exception.InvalidPayloadException;
import com.codetest.estoreevoucher.Exception.InvalidPaymentException;
import com.codetest.estoreevoucher.Model.EvoucherCheckoutDTO;
import com.codetest.estoreevoucher.Model.EvoucherDTO;
import com.codetest.estoreevoucher.Model.PromoCodeVoucherDTO;
import com.codetest.estoreevoucher.Repository.PaymentMethodsRepo;
import com.codetest.estoreevoucher.Service.EVoucherService;

@RestController
@RequestMapping("/api")
public class EVoucherAPI {
	
	@Autowired
	private EVoucherService evoucherService;
	
	@Autowired
	private PaymentMethodsRepo paymentMethodRepo;
	
	@GetMapping("/evouchers/{id}")
	public ResponseEntity<?> retrieveEVoucherDetail(@PathVariable("id") long id) {
		EvoucherDTO evoucher = evoucherService.retrieveEVoucher(id);
		return ResponseEntity.ok(evoucher);
	}

	@GetMapping("/evouchers")
	public ResponseEntity<?> listVouchers() {
		List<EvoucherDTO> evoucher_list = evoucherService.retrieveEVouchers();
		return ResponseEntity.ok(evoucher_list);
	}
	
	@GetMapping("/paymentmethods")
	public ResponseEntity<?> listPaymentMethods(){
		List<PaymentMethod> paymentMethods = paymentMethodRepo.findAll();
		return ResponseEntity.ok(paymentMethods);
	}
	
	@PostMapping("/checkout")
	public ResponseEntity<?> checkoutEVoucher(EvoucherCheckoutDTO checkoutDTO){
		try {
			BuyerInfoEntity buyinfo = evoucherService.purchaseEvocher(checkoutDTO);
			evoucherService.submitPayment(checkoutDTO, buyinfo);
			evoucherService.generatePromocode(buyinfo);
		} catch (InvalidPayloadException | InvalidPaymentException ex) {
			return ResponseEntity.badRequest().build();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/purchaseHistory")
	public ResponseEntity<?> purchaseHistory(){
		UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<PromoCodeVoucherDTO> vouchers = evoucherService.retrievePurchaseHistory(user);
		return ResponseEntity.ok(vouchers);
	}
	
	@GetMapping("/checkPromocode/{promocode}")
	public ResponseEntity<?> checkPromocode(@PathVariable("promocode") String promocode){
		PromoCodeVoucherDTO voucher = evoucherService.checkPromocode(promocode);
		return ResponseEntity.ok(voucher);
	}

}
