package edu.asu.acousticsystem;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import edu.cst316.gompersacousticsystem.Point;
import edu.cst316.gompersacousticsystem.RouteLine;

import org.junit.Before;
import org.junit.Test;

public class RouteLineTest extends TestCase {

	RouteLine test1;
	RouteLine test2;
	
	@Before
	public void setUp() throws Exception {
		test1 = new RouteLine(new Point(4.0, 3.0), new Point(4.0, 6.0), .5);
		test2 = new RouteLine(6.5, 7.0, 0.9, 7.0, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRouteLineDoubleDoubleDoubleDoubleDouble() {
		RouteLine a = new RouteLine(2.0, 3.0, 4.0, 5.0, 2.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRouteLinePointPoint() {
		RouteLine a = new RouteLine(new Point(1.0, 4.0), new Point(1.6, 3.6), 5.5);
	}

	@Test
	public void testOffsetPosition() {
		
		assertTrue(test1.offsetPosition(1.0)== 3.0);
	}

	@Test
	public void testNewPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrientation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStart() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEnd() {
		fail("Not yet implemented");
	}

	@Test
	public void testTooFarFromRoutePoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testTooFarFromRouteDoubleDouble() {
		fail("Not yet implemented");
	}

}
