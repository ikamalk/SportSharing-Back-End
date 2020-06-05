package com.staging.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staging.dao.RequestDao;
import com.staging.models.Request;

@Service
public class RequestService {
	
	@Autowired
	RequestDao requestDao;
	
	
	
	public List<Request> getAllRequest(){
		return requestDao.findAll();
	}

	public Request setRequest(Request r){
		return requestDao.save(r);
	}
}
