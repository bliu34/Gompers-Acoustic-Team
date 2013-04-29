package edu.cst316.gompersacousticsystem;

import java.util.ArrayList;

public class Draw {
	graphFactoryASU myFactory;
	DijkstraManagerASU dmASU;
	ArrayList<Vertex> vertexList;

	public Draw(){
		myFactory = new graphFactoryASU();
		dmASU = new DijkstraManagerASU(myFactory.getGraph());
		vertexList = dmASU.generatePath();
	}

}
