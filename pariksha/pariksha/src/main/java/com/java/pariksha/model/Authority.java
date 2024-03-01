package com.java.pariksha.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userauthority;

	public Authority(String authority) {
		this.userauthority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return userauthority;
	}

}
