package com.java.pariksha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.pariksha.model.UserRegistrationEntity;
@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistrationEntity, Long> {

//	@Query(value="select email from user_registration_tb where ")
	UserRegistrationEntity findByEmail(String email);

}
