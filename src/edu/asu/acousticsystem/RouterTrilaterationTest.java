package edu.asu.acousticsystem;

import edu.asu.acousticsystem.RouterTrilateration;
import edu.asu.acousticsystem.Router;
import junit.framework.TestCase;

public class RouterTrilaterationTest extends TestCase {

	public void testMyTrilateration() {
		
		RouterTrilateration trilateration = new RouterTrilateration();
		
		Router router1 = new Router("Router1");
		Router router2 = new Router("Router2");
		Router router3 = new Router("Router3");
		
		router1.setLevel(-10);
		router2.setLevel(-15);
		router3.setLevel(-20);
		
		router1.setRouterLat(33.533604);
		router2.setRouterLat(33.533568);
		router3.setRouterLat(33.533568);
		
		router1.setRouterLong(-112.116128);
		router2.setRouterLong(-112.115859);
		router3.setRouterLong(-112.115591);
		
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
		
		double[] Mylocation = RouterTrilateration.MyTrilateration(router1.getRouterLat(), router1.getRouterLong(), router1.getLevel(),
									  							  router2.getRouterLat(), router2.getRouterLong(), router2.getLevel(),
									  							  router3.getRouterLat(), router3.getRouterLong(), router3.getLevel());
		
		assertEquals(Mylocation.length, 3);
		
	}

}
