package com.codetest.estoreevoucher.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class PromoCodeVoucher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true)
	private String promocode;
	
	private String qrCodeUrl;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private BuyerInfoEntity buyerInfo;
	
	private String useStatus;
	
	private Date usedDate;
	
	@ManyToOne
	private UserEntity user;
	
}
