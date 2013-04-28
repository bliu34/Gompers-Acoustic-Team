package edu.cst316.gompersacousticsystem;

import android.R.bool;
import edu.cst316.gompersacousticsystem.RouterTrilateration;
import edu.cst316.gompersacousticsystem.Signal;

public class UserLocation {
	Signal signalStrength = new Signal(GestureActivity.getContext());
	Router router1 = new Router("myqwest3331", signalStrength);
	Router router2 = new Router("dlink", signalStrength);
	Router router3 = new Router("belkin-router", signalStrength);
	RouterTrilateration trilateration = new RouterTrilateration(router1, router2, router3);
boolean tracking = true;

	public UserLocation() {

		while (tracking = true) {

			int currentlocation = 0; //location.MyTrilateration();
			System.out.println("You're current location is" + currentlocation);
		}

	}

}
