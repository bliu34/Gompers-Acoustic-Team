package edu.cst316.gompersacousticsystem;

import java.util.ArrayList;

public class DijkstraManager {
	private DijkstraAlgorithm myDa;
	private int latestUserVertex;
	private int curSelectedVertex;
	private ArrayList<Vertex> vertexes;
	
	DijkstraManager(Graph graph)
	{
		myDa = new DijkstraAlgorithm(graph);
		vertexes = (ArrayList<Vertex>)graph.getVertexes();
	}
	
	ArrayList<Vertex> generatePath()
	{
		myDa.execute(vertexes.get(latestUserVertex));
		return new ArrayList<Vertex>(myDa.getPath(vertexes.get(curSelectedVertex)));
	}
	
	void stepSelectedVertex()
	{
		curSelectedVertex++;
		
		if(curSelectedVertex == latestUserVertex)
			curSelectedVertex++;
		
		if(curSelectedVertex >= vertexes.size())
			curSelectedVertex = 0;	
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
	
	boolean changeUserPosition(Point position)
	{
		boolean changed = false;
		for(int i = 0; !changed && i < vertexes.size(); i++)
		{
			if(vertexes.get(i).inArea(position))
			{
				changed = true;
				latestUserVertex = i;
			}
		}
		
		return changed;
	}

}
