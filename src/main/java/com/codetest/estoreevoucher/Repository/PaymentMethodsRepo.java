package com.codetest.estoreevoucher.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetest.estoreevoucher.Entity.PaymentMethod;

public interface PaymentMethodsRepo extends JpaRepository<PaymentMethod, Long>{

}
