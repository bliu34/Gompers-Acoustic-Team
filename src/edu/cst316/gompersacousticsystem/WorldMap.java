package edu.cst316.gompersacousticsystem;

/*
Author: Jian Fang		
Date: December 10, 2010
Title of program: WorldMap.java
Version: [unknown]
Form: [Java code]
Availability: http://code.google.com/p/jianwikis/wiki/AStarAlgorithmForPathPlanning
Date Accessed: Jan. 21, 2013
*/

import java.util.HashMap;
import java.util.Map;

//aAmatrix to hold all positions as follows.
public class WorldMap {
    int rowNum;
    int columnNum;

    String[][] map;
    Map<String, MatrixPosition> index;

    public WorldMap(int rowNum, int columnNum) {
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        map = new String[rowNum][columnNum];
        index = new HashMap<String, MatrixPosition>();
    }
}