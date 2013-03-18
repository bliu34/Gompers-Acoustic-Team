package edu.asu.acousticsystem;

public class Router {
	
	private String SSID;
	private Integer level;
	
	Router(String SSID)
	{
		this.SSID = SSID;
		level = Integer.valueOf(0);
	}
	
	void setLevel(Integer level)
	{
		this.level = level;
	}
	
	String getSSID()
	{
		return SSID;
	}
	
	Integer getLevel()
	{
		return level;
	}
	
	Boolean isSameRouter(String SSID)
	{
		return this.SSID.equals(SSID);
	}
	}

}
