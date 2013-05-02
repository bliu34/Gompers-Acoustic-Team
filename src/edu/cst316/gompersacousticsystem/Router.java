package edu.cst316.gompersacousticsystem;

import java.util.List;

import android.net.wifi.ScanResult;
import android.widget.Toast;

public class Router {

	private String SSID;
	private Signal signalStrength;
	List<ScanResult> results;
	private Integer level;
	private double routerLat;
	private double routerLong;

	public Router(String SSID, Signal signalStrength) {
		this.SSID = SSID;
		this.signalStrength = signalStrength;
		// Signal signalStrength = new Signal(GestureActivity.getContext());
		int i = 0;
		try {
			//level = Integer.valueOf(0);
			// results = signalStrength.getWifiLevels();
			// level =
			// Integer.valueOf((results.get(results.indexOf(SSID)).level));
			results = signalStrength.getWifiLevels();
			for (i = 0; i < results.size() && !results.get(i).SSID.equals(SSID); i++) {
//				System.out.print(results.get(i).SSID + " " + this.SSID + " ");
//				System.out.println(results.get(i).level);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			Toast toast = Toast.makeText(GestureActivity.getContext(), SSID
					+ " is not working.", Toast.LENGTH_SHORT);
			toast.show();
		}
		setLevel(Integer.valueOf(results.get(i).level));
		

	}

	public void update() {
		signalStrength.update();
		results = signalStrength.getWifiLevels();
		int i = 0;
		for (i = 0; i < results.size() && !results.get(i).SSID.equals(SSID); i++) {
			
			setLevel(Integer.valueOf(results.get(i).level));
			if (Integer.valueOf(results.get(i).level) < 0){
				System.exit(1);
			}
		}
		
		
		System.out.println(getSSID() + " " + getLevel());
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
