package edu.cst316.gompersacousticsystem;

import android.R.bool;
import edu.cst316.gompersacousticsystem.RouterTrilateration;
import edu.cst316.gompersacousticsystem.Signal;

public class UserLocation {
	
	RouterTrilateration location = new RouterTrilateration();
	
	boolean tracking;
	tracking = true;
	
	public UserLocation() {
	
		while (tracking = true) {
			
			int currentlocation = location.MyTrilateration();
			System.out.println("You're current location is" + MyLocation);
		} 
			
	}
	
	}
	
}
