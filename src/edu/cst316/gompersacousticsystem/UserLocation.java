package edu.cst316.gompersacousticsystem;

import android.R.bool;
import edu.cst316.gompersacousticsystem.RouterTrilateration;
import edu.cst316.gompersacousticsystem.Signal;

public class UserLocation {
	
	Router router1 = new Router("myqwest3331");
	Router router2 = new Router("dlink");
	Router router3 = new Router("belkin-router");
	RouterTrilateration trilateration = new RouterTrilateration(router1, router2, router3);
boolean tracking = true;

	public UserLocation() {

		while (tracking = true) {

			int currentlocation = 0; //location.MyTrilateration();
			System.out.println("You're current location is" + currentlocation);
		}

	}

}
