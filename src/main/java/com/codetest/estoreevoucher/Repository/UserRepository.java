package com.codetest.estoreevoucher.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetest.estoreevoucher.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	Optional<UserEntity> findByUsername(String username);
}
