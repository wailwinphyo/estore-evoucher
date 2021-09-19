package com.codetest.estoreevoucher.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.estoreevoucher.Entity.RefreshToken;
import com.codetest.estoreevoucher.Entity.Role;
import com.codetest.estoreevoucher.Entity.UserEntity;
import com.codetest.estoreevoucher.Exception.TokenRefreshException;
import com.codetest.estoreevoucher.Model.AuthRequest;
import com.codetest.estoreevoucher.Model.JwtResponse;
import com.codetest.estoreevoucher.Model.TokenRefreshRequest;
import com.codetest.estoreevoucher.Model.TokenRefreshResponse;
import com.codetest.estoreevoucher.Model.UserDTO;
import com.codetest.estoreevoucher.Repository.UserRepository;
import com.codetest.estoreevoucher.Service.RefreshTokenService;
import com.codetest.estoreevoucher.config.JwtTokenUtil;

import ma.glasnost.orika.MapperFacade;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RefreshTokenService refreshTokenService;
	
	@Autowired
	private MapperFacade mapper;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authReq) throws Exception {
		try {
			Authentication authenticate = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));

			final UserEntity user = (UserEntity) authenticate.getPrincipal();

			final String jwt = jwtTokenUtil.generateAccessToken(user);
			String refreshToken = refreshTokenService.createRefreshToken(user.getId()).getToken();
			
			List<String> roles = user.getAuthorities().stream().map(x -> x.getAuthority()).collect(Collectors.toList());
			JwtResponse resp = new JwtResponse(user.getId(), jwt, roles, refreshToken);
			
			return ResponseEntity.ok().body(resp);
			
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> createUser(@RequestBody UserDTO userdto){
		UserEntity user = mapper.map(userdto, UserEntity.class);
		user.setPassword(encoder.encode(user.getPassword()));
		Role role = new Role(1);
		user.setAuthorities(Set.of(role));
		userRepo.save(user);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshtoken(@Validated @RequestBody TokenRefreshRequest request) throws TokenRefreshException {
		String requestRefreshToken = request.getRefreshToken();

		return refreshTokenService.findByToken(requestRefreshToken)
	        .map(refreshTokenService::verifyExpiration)
	        .map(RefreshToken::getUser)
	        .map(user -> {
	          String token = jwtTokenUtil.generateAccessToken(user);
	          return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
	        })
	        .orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
	  }
	
}
