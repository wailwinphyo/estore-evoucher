package com.codetest.estoreevoucher.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetest.estoreevoucher.Entity.EVoucherEntity;

public interface EvoucherRepository extends JpaRepository<EVoucherEntity, Long>{

}
