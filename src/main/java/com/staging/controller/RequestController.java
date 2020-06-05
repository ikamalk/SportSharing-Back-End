package com.staging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.staging.models.Request;
import com.staging.services.RequestService;

@RestController
public class RequestController {
	
	@Autowired
	RequestService requestService;
	
	@GetMapping("request/getall")
	public List<Request> getAll() {
		return requestService.getAllRequest();
	}
	
	@GetMapping("request/set")
	public Request setRequest(@RequestBody Request r) {
		return requestService.setRequest(r);
	}

}
