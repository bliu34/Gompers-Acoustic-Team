package edu.cst316.gompersacousticsystem;

/*
Author: Jian Fang		
Date: December 10, 2010
Title of program: WorldMapLoader.java
Version: [unknown]
Form: [Java code]
Availability: http://code.google.com/p/jianwikis/wiki/AStarAlgorithmForPathPlanning
Date Accessed: Jan. 21, 2013
*/

//Need Map Loader to access WorldMap.
public interface WorldMapLoader {
    WorldMap load(String filePath);
}