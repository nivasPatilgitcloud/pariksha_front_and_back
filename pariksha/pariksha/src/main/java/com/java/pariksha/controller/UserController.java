package com.java.pariksha.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.pariksha.model.UserMasterRole;
import com.java.pariksha.model.UserRegistrationEntity;
import com.java.pariksha.model.UserRole;
import com.java.pariksha.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public UserRegistrationEntity createUser(@RequestBody UserRegistrationEntity userregentity) throws Exception {
		
		userregentity.setProfile("default.png");
		Set<UserMasterRole> roles = new HashSet<>();
		UserRole role = new UserRole();
		role.setRoleid(1L);
		role.setRolename("ADMIN");
		
		UserMasterRole masterRole = new UserMasterRole();
		masterRole.setUser_registration_entity(userregentity);
		masterRole.setUserRole(role);
		
		return this.userService.craeteUser(userregentity, roles);
	}
	
	@GetMapping("getuser/{userid}")
	public void getSingleUser(@PathVariable("userid") Long userid) {
		this.userService.getUserById(userid);
	}
	
	@GetMapping("emailsearch/{email}")
	public UserRegistrationEntity findByemail(@PathVariable("email") String email) {
		return this.userService.findbyemailuser(email);
	}
}
