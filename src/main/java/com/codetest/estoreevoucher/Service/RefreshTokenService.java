package com.codetest.estoreevoucher.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codetest.estoreevoucher.Entity.RefreshToken;
import com.codetest.estoreevoucher.Repository.RefreshTokenRepository;
import com.codetest.estoreevoucher.Repository.UserRepository;
import com.codetest.estoreevoucher.config.JwtConfig;
@Component
public class RefreshTokenService {

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtConfig jwtConfig;
	
	public Optional<RefreshToken> findByToken(String token) {
	    return refreshTokenRepository.findByToken(token);
	  }

	public RefreshToken createRefreshToken(Long userId) {
		RefreshToken refreshToken = new RefreshToken();
		
		refreshToken.setUser(userRepository.findById(userId).get());
		refreshToken.setExpiryDate(Instant.now().plusMillis(jwtConfig.getRefreshTokenExpiration() * 1000));
		refreshToken.setToken(UUID.randomUUID().toString());
		
		refreshToken = refreshTokenRepository.save(refreshToken);
		return refreshToken;
	}
	
	public RefreshToken verifyExpiration(RefreshToken token) {
	    if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
	      refreshTokenRepository.delete(token);
	    }	
	    return token;
	}
	
	  @Transactional
	public int deleteByUserId(Long userId) {
	    return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
	}
}
