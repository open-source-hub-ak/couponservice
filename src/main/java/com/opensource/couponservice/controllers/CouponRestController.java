package com.opensource.couponservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opensource.couponservice.model.Coupon;
import com.opensource.couponservice.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	@Autowired
	private CouponRepo couponRepo;

	@PostMapping("/coupons")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponRepo.save(coupon);
	}

	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return couponRepo.findByCode(code);
	}

}
