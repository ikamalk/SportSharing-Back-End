package com.staging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.staging.models.Account;
import com.staging.models.Request;
import com.staging.services.AccountService;
import com.staging.services.RequestService;

@RestController
public class AccountController {
	

	@Autowired
	AccountService accountService;
	
	
	@GetMapping("get/{username}")
	public Account getAccount(@PathVariable("username") String username) {
		return accountService.getAccountByUsername(username);
	}
}
