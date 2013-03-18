package edu.cst316.gompersacousticsystem;

public class Router {
	
	private String SSID;
	private Integer level;
	private double routerLat;
	private double routerLong;
	
	public Router(String SSID)
	{
		this.SSID = SSID;
		level = Integer.valueOf(0);
	}
	
	public void setLevel(Integer level)
	{
		this.level = level;
	}
	
	public void setRouterLat(double routerLat)
	{
		this.routerLat = routerLat;
	}
	
	public void setRouterLong(double routerLong)
	{
		this.routerLong = routerLong;
	}
	
	public String getSSID()
	{
		return SSID;
	}
	
	public Integer getLevel()
	{
		return level;
	}
	
	public double getRouterLat()
	{
		return routerLat;
	}
	
	public double getRouterLong()
	{
		return routerLong;
	}
	
	public Boolean isSameRouter(String SSID)
	{
		return this.SSID.equals(SSID);
	}
	
}

