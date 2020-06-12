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
	
	public List<Request> getRequestByAccountId(int id){
		return requestDao.findByAccount_id(id);
	}

	public Request setRequest(Request r){
		return requestDao.save(r);
	}
	
	public void deleteRequest(int id){
		requestDao.deleteById(id);
	}
	
	
	
	/*public Request updateRequest(Request r){
		//return requestDao.u
	}*/
}
