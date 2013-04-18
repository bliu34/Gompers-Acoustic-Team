package edu.cst316.gompersacousticsystem.simulation;

public class Node {
	
	private double latitude;
	private double longitude;
	private String locationName;
	
	public Node(String locationName){
		
		this.locationName = locationName;
	}
	
	public void setLatitude(double Lat){
		
		latitude = Lat;
	}
	
	public void setLongitude(double Long){
		
		longitude = Long;
	}
	
	public double getLatitude(){
		
		return latitude;
	}
	
	public double getLongitude(){
		
		return longitude;
	}
	
	public String getLocationName(){
		
		return locationName;
	}

}
