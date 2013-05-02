package edu.cst316.gompersacousticsystem.simulation;

import android.R.bool;
import edu.cst316.gompersacousticsystem.GestureActivity;
import edu.cst316.gompersacousticsystem.Router;
import edu.cst316.gompersacousticsystem.RouterTrilateration;
import edu.cst316.gompersacousticsystem.Signal;

public class UserLocation {
//	Signal signalStrength = new Signal(GestureActivity.getContext());
	//Router router1 = new Router("myqwest3331");
	//Router router2 = new Router("dlink");
	//Router router3 = new Router("belkin-router");
	//RouterTrilateration trilateration = new RouterTrilateration(router1, router2, router3);

	boolean tracking;
	int trackingValue = 0;

public UserLocation(boolean tracking) {
		
		this.tracking = tracking;
		
	}
	
	public int returnTracking(boolean tracking){
		
		this.tracking = tracking;
		
		if (tracking == true) {
			
			trackingValue = 1;
			System.out.println("Tracking current location.");
			
		}
		
		else if(tracking == false){
			trackingValue = 0;
			System.out.println("Unable to track location.");
		}

		
		return trackingValue;
	}


}


