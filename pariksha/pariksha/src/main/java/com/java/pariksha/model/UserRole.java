package com.java.pariksha.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserRole {

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long roleid;
	private String rolename;
	@OneToMany(cascade= CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="userRole")
	private Set<UserMasterRole> userMasterRole = new HashSet<>();
	
	
	public UserRole(Long roleid, String rolename, Set<UserMasterRole> userMasterRole) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
		this.userMasterRole = userMasterRole;
	}
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	public Set<UserMasterRole> getUserMasterRole() {
		return userMasterRole;
	}
	public void setUserMasterRole(Set<UserMasterRole> userMasterRole) {
		this.userMasterRole = userMasterRole;
	}
	@Override
	public String toString() {
		return "UserRole [roleid=" + roleid + ", rolename=" + rolename + ", userMasterRole=" + userMasterRole + "]";
	}
	
}
