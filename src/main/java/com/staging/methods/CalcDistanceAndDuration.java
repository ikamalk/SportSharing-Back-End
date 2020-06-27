package com.staging.methods;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import com.staging.models.Request;

@Component
public class CalcDistanceAndDuration {
	
	public Request getDist(Request request, double GPSLat, double GPSLng) throws ApiException, InterruptedException, IOException{
		//set up key
	   	GeoApiContext distCalcer = new GeoApiContext.Builder()
			    .apiKey("AIzaSyAJnZ3a5krUFvldtEnnNE6RUYRKD1-AISo")
			    .build();
	   	DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer); 
	       DistanceMatrix result = req.origins(new LatLng(GPSLat,GPSLng))
	               .destinations(new LatLng(request.getLat(),request.getLng()))
	               .avoid(RouteRestriction.TOLLS)
	               .language("en-US")
	               .await();
				request.setDuration(result.rows[0].elements[0].duration.inSeconds);
				request.setDistance(distance(GPSLat,GPSLng,request.getLat(),request.getLng(),"M"));
		return request;
	}
	
	
	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}

}
