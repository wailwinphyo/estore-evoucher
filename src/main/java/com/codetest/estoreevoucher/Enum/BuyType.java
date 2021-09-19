package com.codetest.estoreevoucher.Enum;

public enum BuyType {

	OWNUSAGE("Only me usage"),
	GIFTOTHER("Gift to others");
	
	String description;
	
	private BuyType(String description) {
		this.description = description;
	}
}
