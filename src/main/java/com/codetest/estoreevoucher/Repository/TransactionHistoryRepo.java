package com.codetest.estoreevoucher.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetest.estoreevoucher.Entity.TransactionHistory;

public interface TransactionHistoryRepo extends JpaRepository<TransactionHistory, Long>{

}
