package edu.cst316.gompersacousticsystem;

public class Vertex {
	  final private String id;
	  final private String name;
	  final private Area position;
	  
	  
	  public Vertex(String id, String name, Area position) {
	    this.id = id;
	    this.name = name;
	    this.position = position;
	    
	  }
	  
	  public Area getArea(){
		  return position;
	  }
	  public String getId() {
	    return id;
	  }
	  
	  public boolean inArea(Point position) {
		  return this.position.isPointinArea(position);
	  }

	  public String getName() {
	    return name;
	  }
	  
	  @Override
	  public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((id == null) ? 0 : id.hashCode());
	    return result;
	  }
	  
	  @Override
	  public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    Vertex other = (Vertex) obj;
	    if (id == null) {
	      if (other.id != null)
	        return false;
	    } else if (!id.equals(other.id))
	      return false;
	    return true;
	  }
	  
	  public int relativeDirection(Vertex previous){
		  int relativeDirection = 5;
		  Point p = previous.getArea().getBottomLeft();
		  Point p2 = position.getBottomLeft();
		  
		  if(p.getX() == p2.getX()){
			  if(p.getY() > p2.getY())
				  relativeDirection = -1;
			  if(p.getY() < p2.getY())
				  relativeDirection = 1;
		  }
		  else if(p.getX() > p2.getX())
				  relativeDirection = -2;
		  else if(p.getX() < p2.getX())
				  relativeDirection = 2;
		  
		  return relativeDirection;
	  }

	  @Override
	  public String toString() {
	    return name;
	  }
	  
	} 