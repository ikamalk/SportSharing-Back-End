package com.staging.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.staging.models.Account;

public interface UserDao extends JpaRepository<Account, Integer> {
	Account findByUsername(String username);
}
