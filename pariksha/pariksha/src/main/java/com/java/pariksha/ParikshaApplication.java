package com.java.pariksha;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.pariksha.model.UserMasterRole;
import com.java.pariksha.model.UserRegistrationEntity;
import com.java.pariksha.model.UserRole;
import com.java.pariksha.service.UserService;

@SpringBootApplication
public class ParikshaApplication { //implements CommandLineRunner
	
//	@Autowired
//	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ParikshaApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		
//		UserRegistrationEntity userRegistrationEntity = new UserRegistrationEntity();
//		userRegistrationEntity.setFirstname("Nivas");
//		userRegistrationEntity.setLastname("Patil");
//		userRegistrationEntity.setEmail("nivaspatil@gmail.com");
//		userRegistrationEntity.setMobilenumber("9588481077");
//		userRegistrationEntity.setPassword("nivaspatil");
//		
//		UserRole userRole1 = new UserRole();
//		userRole1.setRoleid(22L);
//		userRole1.setRolename("ADMIN");
//		
//		Set<UserMasterRole> userMasterRole = new HashSet<>();
//		UserMasterRole masterRole = new UserMasterRole();
//		
//		masterRole.setUserRole(userRole1);
//		masterRole.setUser_registration_entity(userRegistrationEntity);
//		userMasterRole.add(masterRole);
//		
//		UserRegistrationEntity userRegistrationEntity2 = this.userService.craeteUser(userRegistrationEntity, userMasterRole);
//	}

}
