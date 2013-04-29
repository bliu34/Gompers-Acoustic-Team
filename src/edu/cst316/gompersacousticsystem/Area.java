package edu.cst316.gompersacousticsystem;

public class Area {
	private Point bottomLeft;
	private Point topRight;
	
	public Area(Point bottomLeft, Point topRight){
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}
	
	public boolean isPointinArea(Point location){
		double x = location.getX();
		double y = location.getY();
		if(x >= bottomLeft.getX() && x <= topRight.getX() && y >= bottomLeft.getY() && y<= topRight.getY())
			return true;
		else
			return false;
	}
	
	public Point getBottomLeft(){
		return bottomLeft;
	}

}
