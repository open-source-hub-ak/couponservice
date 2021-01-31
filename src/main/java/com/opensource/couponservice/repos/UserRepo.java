package com.opensource.couponservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opensource.couponservice.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
