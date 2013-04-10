package edu.cst316.gompersacousticsystem.test;

import edu.cst316.gompersacousticsystem.Directory;
import junit.framework.TestCase;

public class DirectoryTest extends TestCase {
	
	public void testDirectory(){
		
		Directory mapDirectory = new Directory();
		
		assertEquals(mapDirectory.getCaseManagerLat(), 35.346534);
		assertEquals(mapDirectory.getCaseManagerLong(), -112.116128);
		
		assertEquals(mapDirectory.getRestroomLat(), 33.346534);
		assertEquals(mapDirectory.getRestroomLong(), -111.116128);
		
		assertEquals(mapDirectory.getCafeteriaLat(), 37.346534);
		assertEquals(mapDirectory.getCafeteriaLong(), -114.116128);
		
		assertEquals(mapDirectory.getHomeLat(), 40.346534);
		assertEquals(mapDirectory.getHomeLong(), -98.116128);
		
		assertEquals(mapDirectory.getFrontLat(), 39.346534);
		assertEquals(mapDirectory.getFrontLong(), -103.116128);
		
		
		
	}

}
