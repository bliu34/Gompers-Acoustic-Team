package edu.cst316.gompersacousticsystem;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Window;
import android.view.WindowManager;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;

public class GestureActivity extends Activity {
	
	TextView gestureEvent;
	DijkstraManagerASU myManager;
	private static Context context;
	Router r1, r2, r3;
	RouterTrilateration rt;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	//Full Screen mode, comment out if you want the bar back
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //End Full Screen
        super.onCreate(savedInstanceState);
        GestureActivity.context = getApplicationContext();
        setContentView(R.layout.main);
        gestureEvent = (TextView)findViewById(R.id.GestureEvent);
        
        ArrayList<Vertex> oh = new ArrayList<Vertex>();
        
        Vertex a = new Vertex("a","a", new Area(new Point(0.0,0.0), new Point(2.0, 2.0)));
        Vertex b = new Vertex("b","b", new Area(new Point(18.0,0.0), new Point(20.0, 2.0)));
        Vertex c = new Vertex("c","c", new Area(new Point(18.0,18.0), new Point(20.0, 20.0)));
        Vertex d = new Vertex("d","d", new Area(new Point(0.0,18.0), new Point(2.0, 20.0)));
        
        oh.add(a);
        oh.add(b);
        oh.add(c);
        oh.add(d);
        
        ArrayList<Edge> arrlist = new ArrayList<Edge>();
        arrlist.add(new Edge("a", a, b, 1));
        arrlist.add(new Edge("b", b, c, 1));
        arrlist.add(new Edge("c", c, d, 1));
        
        Graph darn = (new graphFactoryASU()).getGraph();
        myManager = new DijkstraManagerASU((new graphFactoryASU()).getGraph());
        
        Signal signalStrength = new Signal(getContext());
        r1 = new Router("dlink", signalStrength);
        r2 = new Router("myqwest3331", signalStrength);
        r3 = new Router("belkin-router", signalStrength);

        if(r1.getLevel() <= 0 || r2.getLevel() <= 0 || r3.getLevel() <= 0){
        	
        	System.out.println("Insufficient levels for user tracking.");
        	System.exit(1);
        }
        new RouterTrilateration(r1, r2, r3);
        RouterTrilateration.setLocation();
        
        
    }
    
    @Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
    	return gestureDetector.onTouchEvent(event);
	}

	SimpleOnGestureListener simpleOnGestureListener = new SimpleOnGestureListener() {

	@Override
	public boolean onDoubleTap(MotionEvent e) {
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		System.out.println("DEBUGGING");
		walkLoop();
		return super.onFling(e1, e2, velocityX, velocityY);
	}

	@Override
	public void onLongPress(MotionEvent e) {
	// TODO Auto-generated method stub
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
	// TODO Auto-generated method stub
		myManager.stepSelectedVertex();
		return super.onSingleTapConfirmed(e);
	}
	
	public void walkLoop()
	{
		Point currentPoint;
		double[] trilateratedCoordinates = new double[2];
		ArrayList<String> directions = new ArrayList<String>();
		Signal ourSignal = new Signal(GestureActivity.getContext());
		ArrayList<ScanResult> scanResults;
		ArrayList<Vertex> path = myManager.generatePath();
		directions.add("FORWARD");
		System.out.println(path.toString());
		
		for(int i = 1; i < path.size(); i++ )
			directions.add(path.get(i).whereToTurn(path.get(i-1)));
		
		System.out.println(directions.toString());
		myManager.playSound(8);
		
		while(true){
			r1.update();
			r2.update();
			r3.update();
			scanResults = (ArrayList<ScanResult>)ourSignal.getWifiLevels();
			//giveMeThat = RouterTrilateration.MyTrilateration(0.0,0.0, (double)scanResulsts.get(0).level, 10.0, 20.0, (double)scanResulsts.get(1).level, 20.0, 0.0, (double)scanResulsts.get(2).level);
			trilateratedCoordinates = RouterTrilateration.MyTrilateration();
			currentPoint = new Point(trilateratedCoordinates[0], trilateratedCoordinates[1]);
			boolean haveWeMoved = myManager.changeUserPosition(currentPoint);
			if(haveWeMoved){
			
			for(int i=0; i < directions.size(); i++){
				
				if (directions.get(i) == "RIGHT"){
					myManager.playSound(7);
				}
				
				else if(directions.get(i) == "LEFT"){
					myManager.playSound(6);
				}
				
				else if(directions.get(i) == "FORWARD"){
					myManager.playSound(8);
				}
				
				else if(directions.get(i) == "REVERSE"){
					myManager.playSound(6);
				}
			}
			}
		}
	}

	};
    
    @SuppressWarnings("deprecation")
	GestureDetector gestureDetector = new GestureDetector(simpleOnGestureListener);

	public static Context getContext() {
		return GestureActivity.context;
	}
}

//CODE REVIEW: Matthew Alvarado
/*There are two methods that aren't really being used: onLongPress() and onDoubleTap(). These methods can be deleted. 
 * However, in the case where we would need to implement more behaviors for the gestures, we would be able to use them.
 * In the onCreate() method, we set the vertexes and edges used in the graph of the map, which is good. But when we set the 
 * routers we give it a set signal strength. This shouldn't be the case, if I'm right, since the signal strength is likely to
 * fluctuate. The walkin() method has a lot going on it in and looks pretty confusing. If more comments could be added, I think it
 * would make it a lot cleaner. The for loop that plays the sound based on the element in the directions array
 * could probably be put in it's own function. The walkin() method needs work since we really couldn't use it to guide the user
 * anywhere.
*/
