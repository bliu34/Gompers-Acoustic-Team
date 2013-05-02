package edu.cst316.gompersacousticsystem.test;


import java.util.ArrayList;
import java.util.List;

import edu.cst316.gompersacousticsystem.Area;
import edu.cst316.gompersacousticsystem.DijkstraAlgorithm;
import edu.cst316.gompersacousticsystem.Edge;
import edu.cst316.gompersacousticsystem.Graph;
import edu.cst316.gompersacousticsystem.Point;
import edu.cst316.gompersacousticsystem.Vertex;
import junit.framework.TestCase;

public class DijikstraTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testGetPath() {
		Vertex a = new Vertex("a", "a", new Area(new Point(), new Point()));
		Vertex b = new Vertex("b", "b", new Area(new Point(), new Point()));
		Vertex c = new Vertex("c", "c", new Area(new Point(), new Point()));
		Vertex d = new Vertex("d", "d", new Area(new Point(), new Point()));
		Vertex e = new Vertex("e", "e", new Area(new Point(), new Point()));
		
		Edge edgeA = new Edge("edgeA", a, b, 1);
		Edge edgeB = new Edge("edgeB", b, c, 2);
		Edge edgeC = new Edge("edgeC", c, d, 3);
		Edge edgeD = new Edge("edgeD", d, e, 1);
		Edge edgeE = new Edge("edgeE", b, e, 11);
		
		List<Edge> edgeList = new ArrayList<Edge>();
		edgeList.add(edgeA);
		edgeList.add(edgeB);
		edgeList.add(edgeC);
		edgeList.add(edgeD);
		edgeList.add(edgeE);
		
		List<Vertex> vertexList = new ArrayList<Vertex>();
		vertexList.add(a);
		vertexList.add(b);
		vertexList.add(c);
		vertexList.add(d);
		vertexList.add(e);
		
		Graph myGraph = new Graph(vertexList, edgeList);
		
		DijkstraAlgorithm myDA = new DijkstraAlgorithm(myGraph);
		
		myDA.execute(a);
		ArrayList<Vertex> result;
		ArrayList<Vertex> expected = new ArrayList<Vertex>();
		
		expected.add(a);
		expected.add(b);
		expected.add(c);
		expected.add(d);
		expected.add(e);
		
		result = new ArrayList<Vertex>(myDA.getPath(e));
		
		assertTrue(result.get(0)== expected.get(0));
		assertTrue(result.get(1)== expected.get(1));
		assertTrue(result.get(2)== expected.get(2));
		assertTrue(result.get(3)== expected.get(3));
		assertTrue(result.get(4)== expected.get(4));
		
	}
	
	public void testGetPath2()
	{
		Vertex a = new Vertex("a", "a", new Area(new Point(), new Point()));
		Vertex b = new Vertex("b", "b", new Area(new Point(), new Point()));
		Vertex c = new Vertex("c", "c", new Area(new Point(), new Point()));
		Vertex d = new Vertex("d", "d", new Area(new Point(), new Point()));
		Vertex e = new Vertex("e", "e", new Area(new Point(), new Point()));
		
		Edge edgeA = new Edge("edgeA", a, b, 1);
		Edge edgeB = new Edge("edgeB", b, c, 2);
		Edge edgeC = new Edge("edgeC", c, d, 3);
		Edge edgeD = new Edge("edgeD", d, e, 1);
		Edge edgeE = new Edge("edgeE", b, e, 1);
		
		List<Edge> edgeList = new ArrayList<Edge>();
		edgeList.add(edgeA);
		edgeList.add(edgeB);
		edgeList.add(edgeC);
		edgeList.add(edgeD);
		edgeList.add(edgeE);
		
		List<Vertex> vertexList = new ArrayList<Vertex>();
		vertexList.add(a);
		vertexList.add(b);
		vertexList.add(c);
		vertexList.add(d);
		vertexList.add(e);
		
		Graph myGraph = new Graph(vertexList, edgeList);
		
		DijkstraAlgorithm myDA = new DijkstraAlgorithm(myGraph);
		
		myDA.execute(a);
		ArrayList<Vertex> result;
		ArrayList<Vertex> expected = new ArrayList<Vertex>();
		
		expected.add(a);
		expected.add(b);
		expected.add(e);
		
		result = new ArrayList<Vertex>(myDA.getPath(e));
		
		assertTrue(result.get(0)== expected.get(0));
		assertTrue(result.get(1)== expected.get(1));
		assertTrue(result.get(2)== expected.get(2));
	}
	
	public void testGetPath3()
	{
		Vertex a = new Vertex("a", "a", new Area(new Point(), new Point()));
		Vertex b = new Vertex("b", "b", new Area(new Point(), new Point()));
		Vertex c = new Vertex("c", "c", new Area(new Point(), new Point()));
		Vertex d = new Vertex("d", "d", new Area(new Point(), new Point()));
		Vertex e = new Vertex("e", "e", new Area(new Point(), new Point()));
		Vertex f = new Vertex("f", "f", new Area(new Point(), new Point()));
		Vertex g = new Vertex("g", "g", new Area(new Point(), new Point()));
		
		Edge edgeA = new Edge("edgeA", a, b, 1);
		Edge edgeB = new Edge("edgeB", b, c, 4);
		Edge edgeC = new Edge("edgeC", c, e, 4);
		Edge edgeD = new Edge("edgeD", a, e, 6);
		Edge edgeE = new Edge("edgeE", b, d, 11);
		Edge edgeF = new Edge("edgeF", d, f, 2);
		Edge edgeG = new Edge("edgeG", f, g, 3);
		Edge edgeH = new Edge("edgeH", e, g, 1);
		
		List<Edge> edgeList = new ArrayList<Edge>();
		edgeList.add(edgeA);
		edgeList.add(edgeB);
		edgeList.add(edgeC);
		edgeList.add(edgeD);
		edgeList.add(edgeE);
		edgeList.add(edgeF);
		edgeList.add(edgeG);
		edgeList.add(edgeH);
		
		List<Vertex> vertexList = new ArrayList<Vertex>();
		vertexList.add(a);
		vertexList.add(b);
		vertexList.add(c);
		vertexList.add(d);
		vertexList.add(e);
		vertexList.add(f);
		vertexList.add(g);
		
		Graph myGraph = new Graph(vertexList, edgeList);
		
		DijkstraAlgorithm myDA = new DijkstraAlgorithm(myGraph);
		
		myDA.execute(a);
		ArrayList<Vertex> result;
		ArrayList<Vertex> expected = new ArrayList<Vertex>();
		
		expected.add(a);
		expected.add(e);
		expected.add(g);
		
		result = new ArrayList<Vertex>(myDA.getPath(g));
		
		assertTrue(result.get(0)== expected.get(0));
		assertTrue(result.get(1)== expected.get(1));
		assertTrue(result.get(2)== expected.get(2));
	}
	
	

}