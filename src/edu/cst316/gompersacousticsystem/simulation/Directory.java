package edu.cst316.gompersacousticsystem.simulation;

import edu.cst316.gompersacousticsystem.Node;

public class Directory {

	Node officeNode = new Node("CaseManagerOffices");
	Node restroomNode = new Node("Restrooms");
	Node cafeteriaNode = new Node("Cafeteria");
	Node homeNode = new Node("HomeSeat");
	Node frontNode = new Node("FrontDoors");

	public Directory() {
		
		//Coordinates approximated using Google Maps and floor plan of the building.
		//Not actual coordinates
		
		double officeLat = 33.524548;
		double officeLong = -112.173388;
		officeNode.setLatitude(officeLat);
		officeNode.setLongitude(officeLong);

		double restLat = 33.524399;
		double restLong = -112.173099;
		restroomNode.setLatitude(restLat);
		restroomNode.setLongitude(restLong);

		double cafeteriaLat = 33.524372;
		double cafeteriaLong = -112.173003;
		cafeteriaNode.setLatitude(cafeteriaLat);
		cafeteriaNode.setLongitude(cafeteriaLong);

		double homeLat = 33.524497;
		double homeLong = -112.173094;
		homeNode.setLatitude(homeLat);
		homeNode.setLongitude(homeLong);

		double frontLat = 33.524402;
		double frontLong = -112.173174;
		frontNode.setLatitude(frontLat);
		frontNode.setLongitude(frontLong);
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
