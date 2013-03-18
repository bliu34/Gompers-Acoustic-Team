package edu.cst316.gompersacousticsystem;

import edu.cst316.gompersacousticsystem.*;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;

public class GestureActivity extends Activity {
	
	TextView gestureEvent;
	DijkstraManager myManager;
	private static Context context;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GestureActivity.context = getApplicationContext();
        setContentView(R.layout.main);
        gestureEvent = (TextView)findViewById(R.id.GestureEvent);
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


	};
    
    GestureDetector gestureDetector = new GestureDetector(simpleOnGestureListener);

	public static Context getContext() {
		return GestureActivity.context;
	}
}