package com.staging.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.staging.models.Account;
import com.staging.services.AccountService;

@RestController
public class AccountController {
	

	@Autowired
	AccountService accountService;
	
	
	@GetMapping("account/get/{username}")
	public Account getAccount(@PathVariable("username") String username) {
		return accountService.getAccountByUsername(username);
	}
	
	@PostMapping("account/update")
	public Account updateAccount(@RequestBody Account a) {
		return accountService.updateAccount(a);
	}
}
