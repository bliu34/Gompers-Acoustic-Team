package edu.cst316.gompersacousticsystem;


import java.util.List;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class Signal {
	
	final WifiManager manager;
	
	public Signal(Context myContext)
	{
		Toast toast = Toast.makeText(GestureActivity.getContext(), " Scanning for networks", Toast.LENGTH_SHORT);
		toast.show();
		manager = (WifiManager)myContext.getSystemService(Context.WIFI_SERVICE);
		manager.createWifiLock(WifiManager.WIFI_MODE_SCAN_ONLY, null);
		manager.startScan();
		
		while (manager.getScanResults() == null){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}; 
	}
	
	public List<ScanResult> getWifiLevels()
	{
		return manager.getScanResults();
	}
	

}
