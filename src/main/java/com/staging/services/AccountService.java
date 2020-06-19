package com.staging.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.staging.dao.UserDao;
import com.staging.models.Account;
import com.staging.models.Request;

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
	 
		public Account updateAccount(Account a){
			Optional<Account> accountEntity = userDao.findById(a.getId());
			Account account = accountEntity.get();
			account.setFirstname(a.getFirstname());
			account.setLastname(a.getLastname());
			account.setUsername(a.getUsername());
			account.setPassword(a.getPassword());
			account.setState(a.getState());
			account.setCity(a.getCity());
			account.setPhoneNumber(a.getPhoneNumber());
			account.setBirthday(a.getBirthday());
			return userDao.save(account);
		}
}
