package com.staging.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.staging.dao.UserDao;
import com.staging.models.Account;

@Service
public class AccountService {

	@Autowired
	UserDao userDao;
	
	
	
	 public Account getAccountByUsername(String username) {
		 try {
			   Account account = userDao.findByUsername(username);
			   return account;
		 } catch(UsernameNotFoundException e) {
			   return null;
		 }
	    }
}
