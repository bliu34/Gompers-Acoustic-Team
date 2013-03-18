package edu.cst316.gompersacousticsystem;

import java.util.ArrayList;

public class DijkstraManager {
	private DijkstraAlgorithm myDa;
	private int latestUserVertex;
	private int curSelectedVertex;
	private ArrayList<Vertex> vertexes;
	
	ArrayList<Vertex> generatePath()
	{
		myDa.execute(vertexes.get(latestUserVertex));
		return new ArrayList<Vertex>(myDa.getPath(vertexes.get(curSelectedVertex)));
	}
	
	void stepSelectedVertex()
	{
		
	}
	
	void setLatestUserVertex( int latestVertex)
	{
		latestUserVertex = latestVertex;
	}
	
	int getSelectedVertex()
	{
		return curSelectedVertex;
	}
	
	int getUserVertex()
	{
		return latestUserVertex;
	}
	
	ArrayList<Vertex> getVertexesOnMap()
	{
		return vertexes;
	}
	
	

}
