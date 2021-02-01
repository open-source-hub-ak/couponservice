package com.opensource.couponservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.opensource.couponservice.security.SecurityService;

@Controller
public class UserController {

@Autowired
private SecurityService securityService;
	
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
