package com.opensource.couponservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.opensource.couponservice.model.Coupon;
import com.opensource.couponservice.repos.CouponRepo;

@Controller
public class CouponController {

	@Autowired
	CouponRepo repo;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/createCoupon")
	public String createCoupon() {
		return "createCoupon";
	}

	@PostMapping("/saveCoupon")
	public String save(Coupon coupon) {
		repo.save(coupon);
		return "createResponse";
	}
}
