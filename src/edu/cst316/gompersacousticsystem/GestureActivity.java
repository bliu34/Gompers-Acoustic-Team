package edu.cst316.gompersacousticsystem;

import java.util.ArrayList;

import edu.cst316.gompersacousticsystem.*;
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
	DijkstraManager myManager;
	private static Context context;
	
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
        
        ArrayList<Edge> ah = new ArrayList<Edge>();
        ah.add(new Edge("a", a, b, 1));
        ah.add(new Edge("b", b, c, 1));
        ah.add(new Edge("c",c,d,1));
        
        Graph darn = new Graph(oh, ah);
        myManager = new DijkstraManager(darn);
    }
    
    @Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
    	return gestureDetector.onTouchEvent(event);
	}

	SimpleOnGestureListener simpleOnGestureListener = new SimpleOnGestureListener() {

	@Override
	public boolean onDoubleTap(MotionEvent e) {
	// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
	// TODO Auto-generated method stub
		myManager.generatePath();
		walkin();
		return super.onFling(e1, e2, velocityX, velocityY);
	}

	@Override
	public void onLongPress(MotionEvent e) {
	// TODO Auto-generated method stub
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
	// TODO Auto-generated method stub
		myManager.stepSelectedVertex();
		return super.onSingleTapConfirmed(e);
	}
	
	public void walkin()
	{
		Point currentPoint;
		double[] giveMeThat = new double[3];
		Signal ourSignal = new Signal(context);
		ArrayList<ScanResult> scanResulsts;
		while(true)
		{
			scanResulsts = (ArrayList<ScanResult>)ourSignal.getWifiLevels();
			giveMeThat = RouterTrilateration.MyTrilateration(0.0,0.0, (double)scanResulsts.get(0).level, 10.0, 20.0, (double)scanResulsts.get(1).level, 20.0, 0.0, (double)scanResulsts.get(2).level);
			currentPoint = new Point(giveMeThat[1], giveMeThat[2]);
			myManager.changeUserPosition(currentPoint);
			
		}
	}

	};
    
    GestureDetector gestureDetector = new GestureDetector(simpleOnGestureListener);

	public static Context getContext() {
		return GestureActivity.context;
	}
}