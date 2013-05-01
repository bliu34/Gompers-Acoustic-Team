package edu.cst316.gompersacousticsystem;

import edu.cst316.gompersacousticsystem.Node;

public class Directory {

	Node officeNode = new Node("CaseManagerOffices");
	Node restroomNode = new Node("Restrooms");
	Node cafeteriaNode = new Node("Cafeteria");
	Node homeNode = new Node("HomeSeat");
	Node frontNode = new Node("FrontDoors");

	public Directory() {
		double officeLat = 33.346534;
		double officeLong = -112.116128;
		officeNode.setLatitude(officeLat);
		officeNode.setLongitude(officeLong);

		double restLat = 33.346534;
		double restLong = -112.116128;
		restroomNode.setLatitude(restLat);
		restroomNode.setLongitude(restLong);

		double cafeteriaLat = 33.346534;
		double cafeteriaLong = -112.116128;
		cafeteriaNode.setLatitude(cafeteriaLat);
		cafeteriaNode.setLongitude(cafeteriaLong);

		double homeLat = 33.346534;
		double homeLong = -112.116128;
		homeNode.setLatitude(homeLat);
		homeNode.setLongitude(homeLong);

		double frontLat = 33.346534;
		double frontLong = -112.116128;
		frontNode.setLatitude(frontLat);
		frontNode.setLongitude(frontLat);
	}

	public double getCaseManagerLat() {

		return officeNode.getLatitude();
	}

	public double getCaseManagerLong() {

		return officeNode.getLongitude();
	}

	public double getRestroomLat() {

		return restroomNode.getLatitude();
	}

	public double getRestroomLong() {

		return restroomNode.getLongitude();
	}

	public double getCafeteriaLat() {

		return cafeteriaNode.getLatitude();
	}

	public double getCafeteriaLong() {

		return cafeteriaNode.getLongitude();
	}

	public double getHomeLat() {

		return homeNode.getLatitude();
	}

	public double getHomeLong() {

		return homeNode.getLongitude();
	}

	public double getFrontLat() {

		return frontNode.getLatitude();
	}

	public double getFrontLong() {

		return frontNode.getLongitude();
	}
}

/*Code Review 
	1. Good practice, initiated near the top
	2. Getters and setters look fine.
	3. On line 35 your frontlong should be used, but on line 37, you miscall frontlat.
*/