package com.staging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("request/{id}")
	public List<Request> getById(@PathVariable("id") int id) {
		return requestService.getRequestByAccountId(id);
	}
	
	@PostMapping("request/update")
	public Request updateRequest(@RequestBody Request r) {
		return requestService.updateRequest(r);
	}
	
	@PostMapping("request/set")
	public Request setRequest(@RequestBody Request r) {
		return requestService.setRequest(r);
	}
	
	@DeleteMapping("request/{id}")
	public void deleteRequest(@PathVariable("id") int id) {
		requestService.deleteRequest(id);
	}

}
