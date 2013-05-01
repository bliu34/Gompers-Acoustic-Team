package edu.cst316.gompersacousticsystem;

//////////////////////////////////////////////////////////////////////////////////////////
//*Revised version of Trilateration program*
//Coordinates rewritten to match Gompers Vocational Center
//Unnecessary sub-programs deleted
//Changed calculations slightly
//Implemented Router objects with latitude and longitude coordinates to aid in calculations into them.
//////////////////////////////////////////////////////////////////////////////////////////

public class RouterTrilateration {

	private static Router router1;
	private static Router router2;
	private static Router router3;

	public RouterTrilateration(Router r1, Router r2, Router r3){
		router1 = r1;
		router2 = r2;
		router3 = r3; 
	}
	public static void setLocation(){
		
		router1.setRouterLat(33.306067); //ASU Latitude Coordinates for Demo
		router2.setRouterLat(33.306079);
		router3.setRouterLat(33.306046);
		
		router1.setRouterLong(-111.679155); //ASU Longitude Coordinates for Demo
		router2.setRouterLong(-111.679016);
		router3.setRouterLong(-111.679103);
		
		//router1.setRouterLat(33.524437); //Gompers Latitude Coordinates
		//router2.setRouterLat(33.524344);
		//router3.setRouterLat(33.524347);
		
		//router1.setRouterLong(-112.173313); //Gompers Longitude Coordinates
		//router2.setRouterLong(-112.173544);
		//router3.setRouterLong(-112.172918);
		}
	
	public void updateRouters(){
		router1.update();
		router2.update();
		router3.update();
	}
	
	static double calcDistance(double signal){
		
		//double base = 10;
		//double exponent = -(signal + 51.504)/16.532;
		
		//double distance = Math.pow(base, exponent);
	    //104.09004338 + 13.26842562x + 0.57250833x^2 + 0.00986120x^3 + 0.00006099x^4
		

		//  double distance = 104.09004338 + 13.26842562 * signal + 0.57250833* Math.pow(signal,2)
        //+ 0.00986120*Math.pow(signal, 3) + 0.00006099 * Math.pow(signal,4);
		
		double distance = 730.24198315 + 52.33325511*signal + 1.35152407*Math.pow(signal, 2) 
	    + 0.01481265*Math.pow(signal, 3) + 0.00005900*Math.pow(signal, 4)+0.00541703*180;
		
		return distance;
		
	} 
		 
	// Converts signal distance to latitude and longitude units to find user location
		 static double convertDistToLongLatDegree(double dist) {
			 double result;
			 double DistanceToLongLat;
			 
			//Additional information for calculating Longitudinal distance using Earth Radius for reference as a point
			//Information not really needed though since area is fixed at a point.
			 
			 //final double EarthRadius = 6367449; 
			 //final double a = 6378137;			 
			 //final double b = 6356752.3;
			 //final double ang = lat*(Math.PI/180);
			 
			
//			 degreeResult = Math.cos(ang)*Math.sqrt((Math.pow(a,4)*(Math.pow(Math.cos(ang),2))
//					 + (Math.pow(b,4)*(Math.pow(Math.sin(ang),2)))) 
//					 / (Math.pow((a*Math.cos(ang)),2)+Math.pow((b*Math.sin(ang)),2)))
//					 * Math.PI/180;
			 
			 DistanceToLongLat = 93203.9343;         // unit (meter), based on 33 degrees of Gomper's Latitude at the Vocational Center.
			 result = dist/DistanceToLongLat;		 // convert distance to lat, long degree.
			 return result;
			 
		 }
		 
		 
		//myRotation used for fixing point of location
		 static double[] myRotation(double x, double y, double dist, double deg) {
			 
			 double tmpX, tmpY;
			 //Initialize empty array for temp coordinates
			 double[]  myLocation = new double[3];
			 
			 tmpX = x*Math.cos((Math.PI/180)*deg)-y*Math.sin((Math.PI/180)*deg);
			 tmpY = x*Math.sin((Math.PI/180)*deg)+y*Math.cos((Math.PI/180)*deg);
			 
			 //Append coordinate info into array
			 myLocation[0] = tmpX;
			 myLocation[1] = tmpY;
			 myLocation[2] = dist;
			 
			 return myLocation;
		 }
			 
		   public static double[] MyTrilateration(){
			 //Technical Standard used for accessing info through the internet.
			 //Temporary array for storing coordinates for actual user location
			   
			 //ArrayList<Double> tmpWAP1, tmpWAP2, tmpWAP3;
			 
			 double[] tmpWAP1 = new double[3];
			 double[] tmpWAP2 = new double[3]; 
			 double[] tmpWAP3 = new double[3]; 
			 
			 double dist1, dist2, dist3;		
			 double tmpLat2, tmpLong2, tmpLat3, tmpLong3;
			 double tmpSlide, deg;
			 double MyLat, MyLong;
			 
			 double[] MyLocation = new double[2];
			 
			 router1.update();
			 router2.update();
			 router3.update();
			 
			 dist1 = convertDistToLongLatDegree(calcDistance(router1.getLevel()));
			 dist2 = convertDistToLongLatDegree(calcDistance(router2.getLevel()));
			 dist3 = convertDistToLongLatDegree(calcDistance(router3.getLevel()));
			 
			 tmpLat2 = router2.getRouterLat() - router1.getRouterLat();
			 tmpLong2 = router2.getRouterLong() - router1.getRouterLong();
			 tmpLat3 = router3.getRouterLat() - router1.getRouterLat();
			 tmpLong3 = router3.getRouterLong() - router1.getRouterLong();

			 tmpSlide = Math.sqrt(Math.pow(tmpLat2,2)+Math.pow(tmpLong2,2));
			 
			 //deg = (180/Math.PI)*Math.acos( ((Math.pow(tmpLat2,2) + Math.pow(tmpSlide,2) - Math.pow(tmpLong2, 2)) / (2*tmpLat2*tmpSlide)) );
			 deg = (180/Math.PI)*Math.acos( Math.abs(tmpLat2)/Math.abs(tmpSlide));
			 
			 //Quadrants refer to where on an x/y plane the degrees are mapped.
			 
			 // 1st quadrant
			 if( (tmpLat2>0 && tmpLong2>0) ) {
				 deg = 360 - deg;
			 }
			 // 2nd quadrant
			 else if( (tmpLat2<0 && tmpLong2>0) ) {
				 deg = 180 + deg;
			 }
			 // 3rd quadrant
			 else if( (tmpLat2<0 && tmpLong2<0)){			
				 deg = 180 - deg;
			 }
			 // 4th quadrant
			 else if( (tmpLat2>0 && tmpLong2<0)) {
				 
			 }
			 
			 tmpWAP1[0] = 0.0;
			 tmpWAP1[1] = 0.0;
			 tmpWAP1[2] = dist1;		 
			 tmpWAP2 = myRotation(tmpLat2, tmpLong2, dist2, deg);
			 tmpWAP3 = myRotation(tmpLat3, tmpLong3, dist3, deg);
			 

			 MyLat = (Math.pow(tmpWAP1[2],2)-Math.pow(tmpWAP2[2],2)+Math.pow(tmpWAP2[0],2))/(2*tmpWAP2[0]);
			 
			 MyLong = (Math.pow(tmpWAP1[2],2)-Math.pow(tmpWAP3[2],2)-Math.pow(MyLat,2)
					 +Math.pow(MyLat-tmpWAP3[0],2)+Math.pow(tmpWAP3[1], 2))/(2*tmpWAP3[1]);
			 
			 MyLocation = myRotation(MyLat, MyLong, 0, -deg);
			 
			 MyLocation[0] = MyLocation[0] + router1.getRouterLat();  //Lat1;
			 MyLocation[1] = MyLocation[1] + router1.getRouterLong(); //Long1;
			 
			 return MyLocation;
			 
		 }
}

/* Code Review
 	1. The import java.util.ArrayList is never used.
 	2. The value of the local variable base is not used.
 	3. The value of the local variable exponent is not used.
 	4. Your equations look a bit messy.
*/
