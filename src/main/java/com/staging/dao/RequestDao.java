package com.staging.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.staging.models.Request;

public interface RequestDao extends JpaRepository<Request, Integer> {

}
