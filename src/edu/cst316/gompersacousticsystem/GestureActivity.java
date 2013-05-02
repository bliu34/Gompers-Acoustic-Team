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
        myManager = new DijkstraManagerASU();
        
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
		myManager.walkLoop();
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
