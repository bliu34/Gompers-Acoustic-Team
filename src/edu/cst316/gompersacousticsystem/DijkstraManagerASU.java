package edu.cst316.gompersacousticsystem;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class DijkstraManagerASU {
	private DijkstraAlgorithm myDa;
	private int latestUserVertex;
	private int curSelectedVertex;
	private ArrayList<Vertex> vertexes;

	public DijkstraManagerASU() {
		Graph graph = (new graphFactoryASU()).getGraph();
		myDa = new DijkstraAlgorithm(graph);
		vertexes = (ArrayList<Vertex>) graph.getVertexes();
		latestUserVertex = 4;
		curSelectedVertex = 0;
	}

	public ArrayList<Vertex> generatePath() {
		myDa.execute(vertexes.get(latestUserVertex));
		return new ArrayList<Vertex>(myDa.getPath(vertexes.get(curSelectedVertex)));
	}

	public void stepSelectedVertex() {
		curSelectedVertex++;

		if (curSelectedVertex == latestUserVertex)
			curSelectedVertex++;

		if (curSelectedVertex > vertexes.size())
			curSelectedVertex = 0;

		playSound(curSelectedVertex + 1);
	}

	public void setLatestUserVertex(int latestVertex) {
		latestUserVertex = latestVertex;
	}

	public int getSelectedVertex() {
		return curSelectedVertex;
	}

	public int getUserVertex() {
		return latestUserVertex;
	}

	public ArrayList<Vertex> getVertexesOnMap() {
		return vertexes;
	}

	public boolean changeUserPosition(Point position) {
		boolean changed = false;
		for (int i = 0; !changed && i < vertexes.size(); i++) {
			if (vertexes.get(i).inArea(position)) {
				changed = true;
				latestUserVertex = i;
			}
			if (changed == true){
				if (latestUserVertex == 3){
					playSound(9); //reached destination
				}
				else {
					playSound(6); //Turn Left
				}
			}
		}

		return changed;
	}
	public void walkLoop()
	{
		Point currentPoint;
		double[] trilateratedCoordinates = new double[2];
		ArrayList<String> directions = new ArrayList<String>();
		ArrayList<Vertex> path = generatePath();
		directions.add("FORWARD");
		System.out.println(path.toString());
		
		for(int i = 1; i < path.size(); i++ )
			directions.add(path.get(i).whereToTurn(path.get(i-1)));
		
		System.out.println(directions.toString());
		playSound(8);
		
		while(true){
			//giveMeThat = RouterTrilateration.MyTrilateration(0.0,0.0, (double)scanResulsts.get(0).level, 10.0, 20.0, (double)scanResulsts.get(1).level, 20.0, 0.0, (double)scanResulsts.get(2).level);
			trilateratedCoordinates = RouterTrilateration.MyTrilateration();
			currentPoint = new Point(trilateratedCoordinates[0], trilateratedCoordinates[1]);
			boolean haveWeMoved = changeUserPosition(currentPoint);
			if(haveWeMoved){
			
			for(int i=0; i < directions.size(); i++){
				
				if (directions.get(i) == "RIGHT"){
					playSound(7);
				}
				
				else if(directions.get(i) == "LEFT"){
					playSound(6);
				}
				
				else if(directions.get(i) == "FORWARD"){
					playSound(8);
				}
				
				else if(directions.get(i) == "REVERSE"){
					playSound(6);
				}
			}
			}
		}
	}
	public void playSound(int i) {
		int soundID = 0;
		switch (i) {
		
		case 0:
			soundID = R.raw.door;
			break;
		case 1:
			soundID = R.raw.backleftcorner;
			break;
		case 2:
			soundID = R.raw.door;
			break;
		case 3:
			soundID = R.raw.frontrightcorner;
			break;
		case 4:
			soundID = R.raw.frontleftcorner;
			break;
		case 5:
			soundID = R.raw.backrightcorner;
			break;
		case 6:
			soundID = R.raw.turnleft;
			break;
		case 7:
			soundID = R.raw.turnright;
			break;
		case 8:
			soundID = R.raw.straight;
			break;
		case 9:
			soundID = R.raw.destination;
			break;
		}
		MediaPlayer mp;

		try {
			mp = MediaPlayer.create(GestureActivity.getContext(), soundID);
			mp.start();
			mp.setOnCompletionListener(new OnCompletionListener() {

				public void onCompletion(MediaPlayer mp) {
					mp.release();
					mp = null;

				}
			});
		} catch (Exception exception) {
		}
	}
}
