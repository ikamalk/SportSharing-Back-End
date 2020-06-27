package com.staging.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.errors.ApiException;
import com.staging.dao.RequestDao;
import com.staging.methods.CalcDistanceAndDuration;
import com.staging.models.Request;

@Service
public class RequestService {
	
	@Autowired
	RequestDao requestDao;
	@Autowired
	CalcDistanceAndDuration distanceAndDurationService;
	
	
	public List<Request> getAllRequest(double GPSLat, double GPSLng, double radius){
		List<Request> requests = new ArrayList<Request>();
		for (Request request: requestDao.findAll()) {
			try {
				Request r = distanceAndDurationService.getDist(request, GPSLat, GPSLng);
				if(r.getDistance() <= radius) {
					requests.add(r);
				}
				
			} catch (ApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      };
	      requests.sort(Comparator.comparingDouble(Request::getDistance));
		return requests;
	}
	
	public List<Request> getRequestByAccountId(int id){
		return requestDao.findByAccount_id(id);
	}
	
	public Request getRequestById(int id){
		Optional<Request> requestEntity = requestDao.findById(id);
		return requestEntity.get();
	}

	public Request setRequest(Request r){
		return requestDao.save(r);
	}
	
	public void deleteRequest(int id){
		requestDao.deleteById(id);
	}
	
	
	
	public Request updateRequest(Request r){
		Optional<Request> requestEntity = requestDao.findById(r.getId());
		Request request = requestEntity.get();
		request.setAddress(r.getAddress());
		//request.setParticipants(r.getParticipants());
		request.setPlayer(r.getPlayer());
		request.setSkill_level(r.getSkill_level());
		request.setSport_type(r.getSport_type());
		request.setTime_schedule(r.getTime_schedule());
		request.setPlayer_miss(r.getPlayer_miss());
		return requestDao.save(request);
	}
}
