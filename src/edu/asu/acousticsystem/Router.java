package edu.asu.acousticsystem;

public class Router {
	
	private String SSID;
	private Integer level;
	private double routerLat;
	private double routerLong;
	
	Router(String SSID)
	{
		this.SSID = SSID;
		level = Integer.valueOf(0);
	}
	
	void setLevel(Integer level)
	{
		this.level = level;
	}
	
	void setRouterLat(double routerLat)
	{
		this.routerLat = routerLat;
	}
	
	void setRouterLong(double routerLong)
	{
		this.routerLong = routerLong;
	}
	
	String getSSID()
	{
		return SSID;
	}
	
	Integer getLevel()
	{
		return level;
	}
	
	double getRouterLat()
	{
		return routerLat;
	}
	
	double getRouterLong()
	{
		return routerLong;
	}
	
	Boolean isSameRouter(String SSID)
	{
		return this.SSID.equals(SSID);
	}
	


