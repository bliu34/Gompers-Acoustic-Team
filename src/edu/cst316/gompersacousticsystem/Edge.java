package edu.cst316.gompersacousticsystem;

/*
 Author: Lars Vogel
 Date: 02.11.2009
 Title: Dijkstra's shortest path algorithm in Java
 Version: (1.1)
 Form: Java
 Availability: http://www.vogella.com/articles/JavaAlgorithmsDijkstra/article.html
*/

public class Edge  {
	  private final String id; 
	  private final Vertex source;
	  private final Vertex destination;
	  private final int weight; 
	  
	  public Edge(String id, Vertex source, Vertex destination, int weight) {
	    this.id = id;
	    this.source = source;
	    this.destination = destination;
	    this.weight = weight;
	  }
	  
	  public String getId() {
	    return id;
	  }
	  public Vertex getDestination() {
	    return destination;
	  }

	  public Vertex getSource() {
	    return source;
	  }
	  public int getWeight() {
	    return weight;
	  }
	  
	  @Override
	  public String toString() {
	    return source + " " + destination;
	  }
	  
	  
	} 

