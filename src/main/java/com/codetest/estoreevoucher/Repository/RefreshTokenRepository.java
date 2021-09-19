package com.codetest.estoreevoucher.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetest.estoreevoucher.Entity.RefreshToken;
import com.codetest.estoreevoucher.Entity.UserEntity;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{

	Optional<RefreshToken> findByToken(String token);

	int deleteByUser(UserEntity userEntity);

}
