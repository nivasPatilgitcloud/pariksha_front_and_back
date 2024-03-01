package com.java.pariksha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.pariksha.model.UserRegistrationEntity;
import com.java.pariksha.repository.UserRegistrationRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRegistrationRepository userRegRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserRegistrationEntity useremail = this.userRegRepo.findByEmail(email);
		if(useremail==null) {
			throw new UsernameNotFoundException("User not found");
		}
		return useremail;
	}

}
