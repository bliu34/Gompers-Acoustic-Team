package edu.cst316.gompersacousticsystem;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.View;

public class DijkstraManagerASU {
	private DijkstraAlgorithm myDa;
	private int latestUserVertex;
	private int curSelectedVertex;
	private ArrayList<Vertex> vertexes;

	public DijkstraManagerASU(Graph graph) {
		myDa = new DijkstraAlgorithm(graph);
		vertexes = (ArrayList<Vertex>) graph.getVertexes();
		latestUserVertex = 0;
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
