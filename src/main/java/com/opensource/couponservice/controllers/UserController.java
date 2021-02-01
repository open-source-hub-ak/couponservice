package com.opensource.couponservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.opensource.couponservice.model.User;
import com.opensource.couponservice.repos.UserRepo;
import com.opensource.couponservice.security.SecurityService;

@Controller
public class UserController {

	@Autowired
	private SecurityService securityService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/showRegisterPage")
	public String showRegisterPage() {
		return "registerUser";
	}
	
	@PostMapping("/registerapi")
	public String register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return "login";
	}

	@GetMapping("/")
	public String showLoginPage() {
		return "login";
	}

	@PostMapping("/loginapi")
	public String login(String username, String password) {
		boolean loginResponse = securityService.login(username, password);
		if (loginResponse) {
			return "index";
		}

		return "login";
	}
}
