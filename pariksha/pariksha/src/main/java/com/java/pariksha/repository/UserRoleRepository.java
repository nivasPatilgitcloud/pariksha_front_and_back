package com.java.pariksha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.pariksha.model.UserRole;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
