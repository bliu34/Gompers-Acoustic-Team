package edu.asu.acousticsystem;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

public class Signal {
	
	final WifiManager manager;
	
	Signal(Context myContext)
	{
		manager = (WifiManager)myContext.getSystemService(Context.WIFI_SERVICE);
	}
	
	List<Integer> getWifiLevels()
	{
		List<ScanResult> myResults;
		List<Integer> levels = new ArrayList<Integer>();
		manager.startScan();
		
		myResults = manager.getScanResults();
		
		for (int i = 0; i < myResults.size(); i++)
		{
			levels.add(Integer.valueOf(myResults.get(i).level));
		}
		
		return levels;
		
	}
	
	

}
