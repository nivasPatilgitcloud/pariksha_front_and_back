package com.java.pariksha.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserMasterRole {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long usermaster_roleid;
	@ManyToOne(fetch=FetchType.EAGER)
	private UserRegistrationEntity user_registration_entity;
	@ManyToOne(fetch=FetchType.LAZY)
	private UserRole userRole;
	public UserMasterRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserMasterRole(Long usermaster_roleid, UserRegistrationEntity user_registration_entity, UserRole userRole) {
		super();
		this.usermaster_roleid = usermaster_roleid;
		this.user_registration_entity = user_registration_entity;
		this.userRole = userRole;
	}
	public Long getUsermaster_roleid() {
		return usermaster_roleid;
	}
	public void setUsermaster_roleid(Long usermaster_roleid) {
		this.usermaster_roleid = usermaster_roleid;
	}
	public UserRegistrationEntity getUser_registration_entity() {
		return user_registration_entity;
	}
	public void setUser_registration_entity(UserRegistrationEntity user_registration_entity) {
		this.user_registration_entity = user_registration_entity;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "UserMasterRole [usermaster_roleid=" + usermaster_roleid + ", user_registration_entity="
				+ user_registration_entity + ", userRole=" + userRole + "]";
	}
}
