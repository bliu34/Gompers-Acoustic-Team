package edu.cst316.gompersacousticsystem;

import edu.cst316.gompersacousticsystem.Router;
import edu.cst316.gompersacousticsystem.RouterTrilateration;
import junit.framework.TestCase;

public class RouterTrilaterationTest extends TestCase {

	public void testMyTrilateration() {
		Signal signalStrength = new Signal(GestureActivity.getContext());
		Router router1 = new Router("myqwest3331", signalStrength);
		Router router2 = new Router("dlink", signalStrength);
		Router router3 = new Router("belkin-router", signalStrength);
		RouterTrilateration trilateration = new RouterTrilateration(router1, router2, router3);
	

		router1.setLevel(-10);
		router2.setLevel(-15);
		router3.setLevel(-20);
		
		router1.setRouterLat(33.524437);
		router2.setRouterLat(33.524344);
		router3.setRouterLat(33.524347);
		
		router1.setRouterLong(-112.173313);
		router2.setRouterLong(-112.173544);
		router3.setRouterLong(-112.172918);
		
		/*double signal1 = -10; //Typical maximum received signal power (-10 to -30) of wireless network
		double signal2 = -15;
		double signal3 = -20;
		
		double lat1 = 33.533604;    //Latitude and Longitude Coordinates estimated with Google Maps
		double lat2 = 33.533568;
		double lat3 = 33.533568;
		
		double long1 = -112.116128;
		double long2 = -112.115859;
		double long3 = -112.115591;
		*/
		
		double[] Mylocation = RouterTrilateration.MyTrilateration();
		
		assertEquals(Mylocation.length, 3);
		
	}

}
