package com.codetest.estoreevoucher.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetest.estoreevoucher.Entity.PromoCodeVoucher;
import com.codetest.estoreevoucher.Entity.UserEntity;

public interface PromoCodeVoucherRepo extends JpaRepository<PromoCodeVoucher, Long>{

	List<PromoCodeVoucher> findByUser(UserEntity user);

	PromoCodeVoucher findByPromocode(String promocode);

}
