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
