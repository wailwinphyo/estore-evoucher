package com.codetest.estoreevoucher.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetest.estoreevoucher.Entity.BuyerInfoEntity;

public interface BuyerInfoRepository extends JpaRepository<BuyerInfoEntity, Long>{
	
}
