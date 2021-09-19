package com.codetest.estoreevoucher.Model;

import lombok.Data;

@Data
public class PromoCodeVoucherDTO {
	
	private String promocode;
	
	private String qrCodeUrl;
	
	private String useStatus;
}
