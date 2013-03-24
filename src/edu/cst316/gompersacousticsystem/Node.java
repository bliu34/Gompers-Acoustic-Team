package edu.cst316.gompersacousticsystem;

public class Node {
	
	private float latitude;
	private float longitude;
	private String locationName;
	
	Node(String locationName){
		
		this.locationName = locationName;
	}
	
	void setLatitude(float latitude){
		
		this.latitude = latitude;
	}
	
	void setLongitude(float longitude){
		
		this.longitude = longitude;
	}
	
	float getLatitude(){
		
		return latitude;
	}
	
	float getLongitude(){
		
		return longitude;
	}
	
	String getLocationName(){
		
		return locationName;
	}

}
