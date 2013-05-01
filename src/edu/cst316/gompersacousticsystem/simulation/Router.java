package edu.cst316.gompersacousticsystem.simulation;

import java.util.List;

import android.net.wifi.ScanResult;
import android.widget.Toast;

public class Router {

	private String SSID;
	List<ScanResult> results;
	private Integer level;
	private double routerLat;
	private double routerLong;

	
	public Router() {
		
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public void setRouterLat(double routerLat) {
		this.routerLat = routerLat;
	}

	public void setRouterLong(double routerLong) {
		this.routerLong = routerLong;
	}

	public String getSSID() {
		return SSID;
	}
	
	public void setSSID(String name){
		
		SSID = name;
	}

	public Integer getLevel() {
		return level;
	}

	public double getRouterLat() {
		return routerLat;
	}

	public double getRouterLong() {
		return routerLong;
	}

	public Boolean isSameRouter(String SSID) {
		return this.SSID.equals(SSID);
	}

}
