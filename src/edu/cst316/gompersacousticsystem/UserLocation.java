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

//CODE REVIEW: Matthew Alvarado
/*The purpose of this program was to be able to return an approximate user location based on the calculations from RouterTrilateration
and the router signal strengths. This class uses one Signal object, three Router objects and 1 RouterTrilateration object, but none
of these objects are really being used. The constructor has an infinite loop that prints out "You're current location is" and 0 since
the currentlocation is equal to 0 and doesn't change. The program doesn't really seem to do anything.*/