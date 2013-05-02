package edu.cst316.gompersacousticsystem.simulation;

import java.util.Scanner;

import edu.cst316.gompersacousticsystem.simulation.Directory;
import edu.cst316.gompersacousticsystem.simulation.Router;
import edu.cst316.gompersacousticsystem.simulation.RouterTrilateration;

public class TrilaterationSimulation {
	
	private Router router1 = new Router();
	private Router router2 = new Router();
	private Router router3 = new Router();
	
	private Directory mapDirectory = new Directory();
	
	private RouterTrilateration trilateration = new RouterTrilateration(router1, router1, router1);
	
	
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
		String destination = null;
		
		System.out.println("User, where would you like to go?");
		String userChoice = scanner.next(); 

			if (userChoice == "Offices"){
				
				destination = "Offices";
			}
			
			else if (userChoice == "Restrooms"){
				
				destination = "Restrooms";
			}
			
			else if (userChoice == "Cafeteria"){
				
				destination = "Cafeteria";
			}
			
			else if (userChoice == "Front Doors"){
				
				destination = "Front Doors";
			}
			
			else if (userChoice == "Home"){
				
				destination = "Home";
			}
			
			else{
				
				System.out.println("Please enter an acceptable destination.");
				userChoice = scanner.next(); 
			}
			
			System.out.println("Now taking you to " + destination);
		
		
	}
	
}
