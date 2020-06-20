package com.staging.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.staging.models.Participant;
import com.staging.models.Request;
import com.staging.services.ParticipantService;
import com.staging.services.RequestService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ParticipantController {

	@Autowired
	ParticipantService participantService;
	@Autowired
	RequestService requestService;
	
	
	@PostMapping("participant/set")
	public Participant setParticipant(@RequestBody Participant p) {
		Request request = requestService.getRequestById(p.getRequest().getId());
		request.setPlayer_miss(request.getPlayer_miss() - 1);
		requestService.updateRequest(request);
		return participantService.setParticipant(p);
	}
	
	@GetMapping("participant/account/{id}")
	public List<Participant> getParticipantByAccountId(@PathVariable("id") int id) {
		return participantService.getParticipationByAccountId(id);
	}
	
	@GetMapping("participant/request/{id}")
	public List<Participant> getParticipantByRequestId(@PathVariable("id") int id) {
		return participantService.getParticipationByRequestId(id);
	}
}
