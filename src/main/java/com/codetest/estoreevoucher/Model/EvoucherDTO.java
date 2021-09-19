package com.codetest.estoreevoucher.Model;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EvoucherDTO
{	
	private long id;
	
	private String title;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date expiryDate;

	private MultipartFile image;
	
	private String imageUrl;
	
	private double amount;
	
	private long paymentMethodId;
	
	private double paymentDiscount;
	
	private int quantity;
	
	private String status;

	private int maxBuyLimit;
	
	private int giftPerUserLimit;
	
}
