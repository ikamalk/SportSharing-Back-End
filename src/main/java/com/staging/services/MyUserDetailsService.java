package com.staging.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.staging.dao.UserDao;
import com.staging.models.Account;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserDao userDao;

	   @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		   Account account = userDao.findByUsername(username);
		   if(username.equals(account.getUsername()))
	        return new User(account.getUsername(), "{noop}"+account.getPassword(),
	                new ArrayList<>());
		   return null;
	    }
	  // passwordEncoder.encode(account.getPassword()
	   
	   public Account insertAccount(Account account) {
		   account.setPassword(account.getPassword());
			return userDao.save(account);
		}
	   
}
