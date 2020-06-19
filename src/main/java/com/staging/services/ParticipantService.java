package com.staging.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staging.dao.ParticipantDao;
import com.staging.dao.RequestDao;
import com.staging.models.Participant;

@Service
public class ParticipantService {
	
	@Autowired
	ParticipantDao participantDao;
	
	public Participant setParticipant(Participant p){
		return participantDao.save(p);
	}
	public List<Participant> getParticipationByAccountId(int id) {
		return participantDao.findByaccountId(id);
	}
	
	public List<Participant> getParticipationByRequestId(int id) {
		return participantDao.findByrequest_id(id);
	}
	

}
