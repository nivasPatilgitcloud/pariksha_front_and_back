package com.java.pariksha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.pariksha.config.JwtUtil;
import com.java.pariksha.model.JwtRequest;
import com.java.pariksha.service.UserDetailsServiceImpl;

@RestController
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authmanager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			authenticate(jwtRequest.getEmail(), jwtRequest.getPassword());
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		}
		
		UserDetails userDetails = this.userDetailServiceImpl.loadUserByUsername(jwtRequest.getEmail());
		String token = this.jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(token);
	}
	
	private void authenticate(String useremail, String password) throws Exception {
		
		try {
			authmanager.authenticate(new UsernamePasswordAuthenticationToken(useremail, password));
		}catch(DisabledException e) {
			throw new Exception("User disabled : "+e.getMessage());
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid credentials : "+e.getMessage());
			
		}
		
	}
}
