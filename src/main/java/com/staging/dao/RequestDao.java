package com.staging.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.staging.models.Request;

public interface RequestDao extends JpaRepository<Request, Integer> {
	List<Request> findByAccount_id(int id);

}
