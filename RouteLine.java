package edu.asu.acousticsystem;

public class RouteLine{
	
	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;
	
	protected Point start;
	protected Point end;
	protected int orientation;
	protected double halfWidth;
	
	RouteLine()
	{
		start = new Point(0, 0);
		end = new Point(0, 1);
		orientation = VERTICAL;
		halfWidth = 0.5;
	}
	
	RouteLine( double x1, double y1, double x2, double y2, double halfWidth)
	{
		if(x1 == x2)
		{
			start = new Point(x1, y1);
			end = new Point(x2, y2);
			this.halfWidth = halfWidth;
			orientation = VERTICAL;
		}
		else if(y1 == y2)
		{
			start = new Point(x1, y1);
			end = new Point(x2, y2);
			this.halfWidth = halfWidth;
			orientation = HORIZONTAL;
		}
		else
			throw new IllegalArgumentException("Route is neither horizontal or vertical");
	}
	
	RouteLine( Point start, Point end, double halfWidth)
	{
		if(start.getX() == end.getX())
		{
			this.start = start;
			this.end = end;
			orientation = VERTICAL;
			this.halfWidth = halfWidth;
		}
		else if (start.getY() == end.getY())
		{
			this.start = start;
			this.end = end;
			orientation = HORIZONTAL;
			this.halfWidth = halfWidth;
		}
		else
			throw new IllegalArgumentException("Route is neither horizontal or vertical");
	}
	
	double offsetPosition(double dPos)
	{
		double distanceFromEnd;
		
		if (orientation == VERTICAL)
		{
			start.setY(start.getY()+dPos);
			distanceFromEnd = getLength();
		}
		else
		{
			start.setX(start.getX()+dPos);
			distanceFromEnd = getLength();
		}
		
		return distanceFromEnd;
	}
	
	double newPosition(double pos)
	{
		double distanceFromEnd;
		
		if(orientation == VERTICAL)
		{
			start.setY(pos);
			distanceFromEnd = getLength();
		}
		else
		{
			start.setX(pos);
			distanceFromEnd = getLength();
		}
		
		return distanceFromEnd;
	}
	
	int getOrientation()
	{
		return orientation;
	}
	
	Point getStart()
	{
		return start;
	}
	
	Point getEnd()
	{
		return end;
	}
	
	double getHalfWidth()
	{
		return halfWidth;
	}
	
	boolean tooFarFromRoute(Point currentPos)
	{
		boolean tooFar = false;
		
		if(orientation == HORIZONTAL && (currentPos.getY() > (start.getY() + halfWidth) || currentPos.getY()< (start.getY()-halfWidth)) )
			tooFar = true;
		else if(orientation == VERTICAL && (currentPos.getX() > (start.getX() + halfWidth) || currentPos.getX()< (start.getX()-halfWidth)) )
			tooFar = true;
		
		return tooFar;
	}
	
	boolean tooFarFromRoute(double x, double y)
	{
		boolean tooFar = false;
		
		if(orientation == HORIZONTAL && (y > (start.getY() + halfWidth) || y < (start.getY()-halfWidth)) )
			tooFar = true;
		else if(orientation == VERTICAL && (x > (start.getX() + halfWidth) || x < (start.getX()-halfWidth)) )
			tooFar = true;
		
		return tooFar;
	}
	
	double getLength()
	{
		double length;
		if( orientation == VERTICAL)
			length = end.getY()- start.getY();
		else 
			length = end.getX() - start.getX();
		return length;
			
	}

}
