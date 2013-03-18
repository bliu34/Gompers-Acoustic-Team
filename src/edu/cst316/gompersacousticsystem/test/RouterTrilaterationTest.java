package edu.cst316.gompersacousticsystem.test;

import edu.cst316.gompersacousticsystem.test.RouterTrilateration;
import junit.framework.TestCase;

public class RouterTrilaterationTest extends TestCase {

	public void testMyTrilateration() {
		
		RouterTrilateration trilateration = new RouterTrilateration();
		
		double signal1 = -10; //Typical maximum received signal power (-10 to -30) of wireless network
		double signal2 = -15;
		double signal3 = -20;
		
		double lat1 = 33.533604;    //Latitude and Longitude Coordinates estimated with Google Maps
		double lat2 = 33.533568;
		double lat3 = 33.533568;
		
		double long1 = -112.116128;
		double long2 = -112.115859;
		double long3 = -112.115591;
		
		double[] Mylocation = RouterTrilateration.MyTrilateration(lat1, long1, signal1,
									  lat2, long2, signal2,
									  lat3, long3, signal3);
		
		assertEquals(Mylocation.length, 3);
		
	}

}
