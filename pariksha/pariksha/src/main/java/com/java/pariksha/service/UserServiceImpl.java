package com.java.pariksha.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.pariksha.model.UserMasterRole;
import com.java.pariksha.model.UserRegistrationEntity;
import com.java.pariksha.repository.UserRegistrationRepository;
import com.java.pariksha.repository.UserRoleRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRegistrationRepository userRegRepo;
	@Autowired
	private UserRoleRepository userRoleRepo;
	
	@Override
	public UserRegistrationEntity craeteUser(UserRegistrationEntity userRegistrationEntity,
			Set<UserMasterRole> userMasterRole) throws Exception {
		// check whether user is already present in db
		UserRegistrationEntity userCheckData = this.userRegRepo.findByEmail(userRegistrationEntity.getEmail());
		if(userCheckData!=null) {
			System.out.println("User already exist with provided email. Try with different email.");
			throw new Exception("User already exist with provided email. Try with different email.");			
		}else {
			for(UserMasterRole usrrole: userMasterRole) {
				this.userRoleRepo.save(usrrole.getUserRole());
			}
			userRegistrationEntity.getUserRoles().addAll(userMasterRole);
			userCheckData = this.userRegRepo.save(userRegistrationEntity);
		}
		
		return userCheckData;
	}

	@Override
	public void getUserById(Long userid) {
		this.userRegRepo.findById(userid);
	}
	
	@Override
	public UserRegistrationEntity findbyemailuser(String email) {
		return this.userRegRepo.findByEmail(email);
	}

}
