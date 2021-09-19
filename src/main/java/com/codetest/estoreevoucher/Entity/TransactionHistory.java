package com.codetest.estoreevoucher.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity(name = "TransactionHistory")
public class TransactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Date transDate;
	
	private double amount;
}
