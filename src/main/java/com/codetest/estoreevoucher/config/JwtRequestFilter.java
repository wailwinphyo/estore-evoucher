package com.codetest.estoreevoucher.config;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.codetest.estoreevoucher.Repository.UserRepository;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	private JwtTokenUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private JwtConfig jwtConfig;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		try {
			String jwt = parseJwt(request);
			if(jwt != null && jwtUtil.validate(jwt)) {
		        UserDetails userDetails = userRepo
		                .findByUsername(jwtUtil.getUsername(jwt))
		                .orElse(null);
		        
		        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
		            		userDetails, null, userDetails.getAuthorities());
		        authentication
                	.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		        SecurityContextHolder.getContext().setAuthentication(authentication);
			}	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		chain.doFilter(request, response);
	}
	
	private String parseJwt(HttpServletRequest req) {
		String headerAuth = req.getHeader(jwtConfig.getHeader());
		if(StringUtils.hasText(headerAuth) && headerAuth.startsWith(jwtConfig.getPrefix())) {
			return headerAuth.substring(7, headerAuth.length());
		}
		return null;
	}

}
