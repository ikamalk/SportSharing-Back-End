package com.staging.dao;

import com.staging.models.Participant;
import com.staging.models.Request;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ParticipantDao extends JpaRepository<Participant, Integer>{

	List<Participant> findByaccountId(int id);
	List<Participant> findByrequest_id(int id);

}