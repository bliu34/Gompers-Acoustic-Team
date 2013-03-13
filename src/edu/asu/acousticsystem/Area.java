package edu.asu.acousticsystem;

public class Area {
	Point bottomLeft;
	Point topRight;
	
	Area(Point bottomLeft, Point topRight){
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}
	
	public boolean isPointinArea(Point location)
	{
		double x = location.getX();
		double y = location.getY();
		if(x >= bottomLeft.getX() && x <= topRight.getX() && y >= bottomLeft.getY() && y<= topRight.getY())
			return true;
		else
			return false;
	}

}
