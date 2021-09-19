package com.codetest.estoreevoucher.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "EVoucher")
public class EVoucherEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;

	private String title;
	
	private Date expiryDate;
	
	private String imageUrl;
	
	private double amount;
	
	private int quantity;
	
	private int maxBuyLimit;
	
	private int giftPerUserLimit;
	
	private String status;

	@ManyToOne
	private PaymentMethod paymentMethod;
	
	private double paymentDiscount;
}