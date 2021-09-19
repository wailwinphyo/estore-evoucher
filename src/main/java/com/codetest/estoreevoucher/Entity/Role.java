package com.codetest.estoreevoucher.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Role implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1078453798322857758L;

	public Role(Integer id) {
		this.id = id;
	}
	
	@Id
	private Integer id;
	
	private String authority;
}
