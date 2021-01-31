package com.opensource.couponservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opensource.couponservice.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
