package edu.cst316.gompersacousticsystem.simulation;

import java.util.Scanner;

import edu.cst316.gompersacousticsystem.simulation.Directory;
import edu.cst316.gompersacousticsystem.simulation.Node;
import edu.cst316.gompersacousticsystem.simulation.Router;
import edu.cst316.gompersacousticsystem.simulation.RouterTrilateration;
import edu.cst316.gompersacousticsystem.simulation.Signal;
import edu.cst316.gompersacousticsystem.simulation.UserLocation;

public class TrilaterationSimulation {

	private Router router1 = new Router("Router1");
	private Router router2 = new Router("Router2");
	private Router router3 = new Router("Router3");
	
	private Directory mapDirectory = new Directory();
	
	private RouterTrilateration trilateration = new RouterTrilateration();
	
	
	public TrilaterationSimulation(){
		
		//Coordinates approximated using Google Maps
		//Not necessarily the actual coordinates we will use.
		router1.setLevel(-10);
		router1.setRouterLat(33.524557);
		router1.setRouterLong(-112.173361);
		
		router2.setLevel(-15);
		router2.setRouterLat(33.524543);
		router2.setRouterLong(-112.173079);
		
		router3.setLevel(-20);
		router3.setRouterLat(33.524470);
		router3.setRouterLong(-112.173060);
	
	}
	
	public void main(){
		
		Scanner scanner = new Scanner(System.in);
		
		String currentLocation;
		String destination;
		
		
		
		System.out.println("User, where would you like to go?");
		String userChoice = scanner.next(); 
		
		while (userChoice != "Exit"){
			
			if (userChoice == "Offices"){
				
				
			}
			
			if (userChoice == "Restrooms"){
				
				
			}
			
			if (userChoice == "Cafeteria"){
				
				
			}
			
			if (userChoice == "Front Doors"){
				
				
			}
			
			if (userChoice == "Home"){
				
				
			}
		}
		
	}
	
}
