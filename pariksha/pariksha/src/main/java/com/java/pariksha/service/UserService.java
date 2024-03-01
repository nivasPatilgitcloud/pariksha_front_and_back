package com.java.pariksha.service;

import java.util.Set;

import com.java.pariksha.model.UserMasterRole;
import com.java.pariksha.model.UserRegistrationEntity;

public interface UserService {

	
	public UserRegistrationEntity craeteUser(UserRegistrationEntity userRegistrationEntity, Set<UserMasterRole> userMasterRole)throws Exception;
	public void getUserById(Long userid);
	public UserRegistrationEntity findbyemailuser(String email);
}
