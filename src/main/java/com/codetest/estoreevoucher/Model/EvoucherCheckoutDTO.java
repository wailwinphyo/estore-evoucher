package com.codetest.estoreevoucher.Model;

import lombok.Data;

@Data
public class EvoucherCheckoutDTO {

	private long evoucherId;
	private int quantity;
	
	private long paymentMethod;
	private String creditCardNumber;
	private String name;
	private String phoneNumber;
}
