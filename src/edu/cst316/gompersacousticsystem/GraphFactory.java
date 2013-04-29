package edu.cst316.gompersacousticsystem;

import java.util.ArrayList;
import java.util.List;

import edu.cst316.gompersacousticsystem.Edge;
import edu.cst316.gompersacousticsystem.Point;
import edu.cst316.gompersacousticsystem.Vertex;

public class GraphFactory {
	
	private List<Edge> edgeList;
	private List<Vertex> vertexList;
	private Graph myGraph;
	
	public GraphFactory()
	{
		Vertex caseManagerTurnArea = new Vertex("Case manager turn area", 
				"Case manager turnArea", new Area(new Point(75, 35), new Point(80, 40)));
		Vertex caseManagers = new Vertex("Case managers", "Case managers", 
				new Area(new Point(75, 10),new Point(80, 15) ));
		Vertex backDoors = new Vertex("Back doors", "Back doors",
				new Area(new Point(35, 0), new Point(40, 5)));
		Vertex frontDoors = new Vertex("Front doors", "Front doors", 
				new Area(new Point(35, 35), new Point(40, 40)));
		Vertex bathrooms = new Vertex("Bathrooms", "Bathrooms",
				new Area(new Point(10, 35), new Point(15, 40)));
		Vertex cafeteria = new Vertex("Cafeteria", "Cafeteria", 
				new Area(new Point(0, 35), new Point(5, 40)));
		
		vertexList = new ArrayList<Vertex>();
		vertexList.add(cafeteria);
		vertexList.add(bathrooms);
		vertexList.add(frontDoors);
		vertexList.add(backDoors);
		vertexList.add(caseManagerTurnArea);
		vertexList.add(caseManagers);
		
		Edge cafToBath = new Edge("caf to bath", cafeteria, bathrooms, 10);
		Edge bathToFront = new Edge("bath to front", bathrooms, frontDoors, 25);
		Edge frontToBack = new Edge("front to back", frontDoors, backDoors, 35);
		Edge frontToCaseTurn = new Edge("front to case turn", frontDoors, caseManagerTurnArea, 40);
		Edge caseTurnToManagers = new Edge("case turn to managers", caseManagerTurnArea, caseManagers, 25);
		
		edgeList = new ArrayList<Edge>();
		
		edgeList.add(cafToBath);
		edgeList.add(bathToFront);
		edgeList.add(frontToBack);
		edgeList.add(frontToCaseTurn);
		edgeList.add(caseTurnToManagers);
		
		myGraph = new Graph(vertexList, edgeList);
	}
	
	public List<Vertex> getVertices()
	{
		return vertexList;
	}
	
	public List<Edge> getEdges()
	{
		return edgeList;
	}
	
	public Graph getGraph()
	{
		return myGraph;
	}

}
