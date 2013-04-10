package edu.cst316.gompersacousticsystem.test;

import junit.framework.TestCase;
import edu.cst316.gompersacousticsystem.Node;


public class NodeTest extends TestCase {

	public void testNode(){
		
		Node node1 = new Node("Node1");
		Node node2 = new Node("Node2");
		Node node3 = new Node("Node3");
		
		node1.setLatitude(123.456);
		node2.setLatitude(120.765);
		node3.setLatitude(119.123);
		
		node1.setLongitude(99.123);
		node2.setLongitude(99.456);
		node3.setLongitude(99.789);
		
		assertEquals(node1.getLatitude(), 123.456);
		assertEquals(node2.getLatitude(), 120.765);
		assertEquals(node3.getLatitude(), 119.123);
		
		assertEquals(node1.getLongitude(), 99.123);
		assertEquals(node2.getLongitude(), 99.456);
		assertEquals(node3.getLongitude(), 99.789);
		
		
	}
}
