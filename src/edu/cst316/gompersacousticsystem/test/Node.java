package edu.cst316.gompersacousticsystem.test;


public class Node {
	
	private double latitude;
	private double longitude;
	private String locationName;
	
	Node(String locationName){
		
		this.locationName = locationName;
	}
	
	void setLatitude(double Lat){
		
		latitude = Lat;
	}
	
	void setLongitude(double Long){
		
		longitude = Long;
	}
	
	double getLatitude(){
		
		return latitude;
	}
	
	double getLongitude(){
		
		return longitude;
	}
	
	String getLocationName(){
		
		return locationName;
	}

}
