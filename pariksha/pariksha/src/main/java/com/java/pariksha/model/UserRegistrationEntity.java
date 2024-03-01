package com.java.pariksha.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_registration_tb")
public class UserRegistrationEntity implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	private String firstname;
	private String lastname;
	private String email;
	private String mobilenumber;
	private String password;
	private boolean enabled = true;
	private String profile;
	
	//user many roles
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="user_registration_entity")
	@JsonIgnore
	private Set<UserMasterRole> userRoles = new HashSet<>();
	
	
	
	public UserRegistrationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRegistrationEntity(Long userid, String firstname, String lastname, String email, String mobilenumber,
			String password, boolean enabled, String profile, Set<UserMasterRole> userRoles) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.password = password;
		this.enabled = enabled;
		this.profile = profile;
		this.userRoles = userRoles;
	}
	//getters and setters
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public Set<UserMasterRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserMasterRole> userRoles) {
		this.userRoles = userRoles;
	}
	@Override
	public String toString() {
		return "UserRegistrationEntity [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", mobilenumber=" + mobilenumber + ", password=" + password + ", enabled="
				+ enabled + ", profile=" + profile + ", userRoles=" + userRoles + "]";
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    Set<Authority> authrole = new HashSet<>();
	    this.userRoles.forEach(userRole -> {
	        authrole.add(new Authority(userRole.getUserRole().getRolename()));
	        System.out.println("Loaded role: " + userRole.getUserRole().getRolename()); // Logging for debug
	    });
	    if(authrole.isEmpty()) {
	        System.out.println("No authorities found for user: " + this.getEmail());	        
	    }
	    return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getEmail();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}	
	
	
}
