package com.codetest.estoreevoucher.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "BuyerInfo")
public class BuyerInfoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String phoneNumber;
	
	private int quantity;
	
	private Date CreatedDateTime;
	
	private String status;
	
	private double amount;
	
	@ManyToOne
	private EVoucherEntity evoucher;
	
	@ManyToOne
	private UserEntity user;
	
	@OneToOne
	private TransactionHistory transactionHistory;
}


