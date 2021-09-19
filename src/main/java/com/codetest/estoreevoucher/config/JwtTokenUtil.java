package com.codetest.estoreevoucher.config;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codetest.estoreevoucher.Entity.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil {

	@Autowired
	private JwtConfig jwtConfig;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public String generateAccessToken(UserEntity user) {
		return Jwts.builder().setSubject(user.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + (jwtConfig.getExpiration() * 1000)))
				.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret()).compact();
	}

	public String getUsername(String token) {
		Claims claims = Jwts.parser()
							.setSigningKey(jwtConfig.getSecret())
							.parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public Date getExpirationDate(String token) {
		Claims claims = Jwts.parser()
							.setSigningKey(jwtConfig.getSecret())
							.parseClaimsJws(token).getBody();
		return claims.getExpiration();
	}

	public boolean validate(String token) {
		try {
			Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(token);
			return true;
		} catch (SignatureException ex) {
			logger.error("Invalid JWT signature - {}", ex.getMessage());
		} catch (MalformedJwtException ex) {
			logger.error("Invalid JWT token - {}", ex.getMessage());
		} catch (ExpiredJwtException ex) {
			logger.error("Expired JWT token - {}", ex.getMessage());
		} catch (UnsupportedJwtException ex) {
			logger.error("Unsupported JWT token - {}", ex.getMessage());
		} catch (IllegalArgumentException ex) {
			logger.error("JWT claims string is empty - {}", ex.getMessage());
		}
		return false;
	}

}
