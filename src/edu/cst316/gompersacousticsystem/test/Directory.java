package edu.cst316.gompersacousticsystem.test;

import edu.cst316.gompersacousticsystem.test.Node;

public class Directory {

	Node officeNode = new Node("CaseManagerOffices");
	Node restroomNode = new Node("Restrooms");
	Node cafeteriaNode = new Node("Cafeteria");
	Node homeNode = new Node("HomeSeat");
	Node frontNode = new Node("FrontDoors");

	public Directory() {
		double officeLat = 35.346534;
		double officeLong = -112.116128;
		officeNode.setLatitude(officeLat);
		officeNode.setLongitude(officeLong);

		double restLat = 33.346534;
		double restLong = -111.116128;
		restroomNode.setLatitude(restLat);
		restroomNode.setLongitude(restLong);

		double cafeteriaLat = 37.346534;
		double cafeteriaLong = -114.116128;
		cafeteriaNode.setLatitude(cafeteriaLat);
		cafeteriaNode.setLongitude(cafeteriaLong);

		double homeLat = 40.346534;
		double homeLong = -98.116128;
		homeNode.setLatitude(homeLat);
		homeNode.setLongitude(homeLong);

		double frontLat = 39.346534;
		double frontLong = -103.116128;
		frontNode.setLatitude(frontLat);
		frontNode.setLongitude(frontLat);
	}

	double getCaseManagerLat() {

		return officeNode.getLatitude();
	}

	double getCaseManagerLong() {

		return officeNode.getLongitude();
	}

	double getRestroomLat() {

		return restroomNode.getLatitude();
	}

	double getRestroomLong() {

		return restroomNode.getLongitude();
	}

	double getCafeteriaLat() {

		return cafeteriaNode.getLatitude();
	}

	double getCafeteriaLong() {

		return cafeteriaNode.getLongitude();
	}

	double getHomeLat() {

		return homeNode.getLatitude();
	}

	double getHomeLong() {

		return homeNode.getLongitude();
	}

	double getFrontLat() {

		return frontNode.getLatitude();
	}

	double getFrontLong() {

		return frontNode.getLongitude();
	}
}
