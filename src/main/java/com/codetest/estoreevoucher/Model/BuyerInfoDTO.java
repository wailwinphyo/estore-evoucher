package com.codetest.estoreevoucher.Model;

import java.io.Serializable;

public class BuyerInfoDTO implements Serializable {
	
	public long id;

	public String buyType;
	
	public String name;
	
	public int phoneNumber;
	
	public int maxLimit;
	
	public int giftPerUserLimit;
}
