package edu.cst316.gompersacousticsystem.simulation;


import java.util.List;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

public class Signal {
	
	final WifiManager manager;
	
	public Signal(Context myContext)
	{
		manager = (WifiManager)myContext.getSystemService(Context.WIFI_SERVICE);
	}
	
	public List<ScanResult> getWifiLevels()
	{
		manager.startScan();
		return manager.getScanResults();
	}
	

}
