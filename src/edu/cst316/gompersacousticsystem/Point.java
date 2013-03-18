package edu.cst316.gompersacousticsystem;

public class Point {
	private double x;
	private double y;
	
	public Point()
	{
		x = 0.0;
		y = 0.0;
	}
	
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void changePoint(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setX(double x)
	{
		this.x = x;
	}
	
	public void setY(double y)
	{
		this.y = y;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
}
