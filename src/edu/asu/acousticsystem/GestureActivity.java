package edu.asu.acousticsystem;

import edu.cst316.gompersacousticsystem.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;

//This is a simple tap/gesture calculator.

public class GestureActivity extends Activity {
	
	TextView gEvent;
	
    /* Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gEvent = (TextView)findViewById(R.id.GestureEvent);
    }
    
    @Override
	public boolean onTouchEvent(MotionEvent event) {
    	return gestureDetector.onTouchEvent(event);
	}

	SimpleOnGestureListener simpleOnGestureListener
    = new SimpleOnGestureListener(){

		@Override
		public boolean onDoubleTap(MotionEvent e) {
			gEvent.setText("Double Tap: \n" + e.toString());
			return super.onDoubleTap(e);
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			gEvent.setText("Swipe: \n" + e1.toString() + "\n" + e2.toString() + "\n");
			return super.onFling(e1, e2, velocityX, velocityY);
		}

		@Override
		public void onLongPress(MotionEvent e) {
			gEvent.setText("Long Press: \n" + e.toString());
			super.onLongPress(e);
		}

		@Override
		public boolean onSingleTapConfirmed(MotionEvent e) {
			gEvent.setText("Single Tap Confirmed: \n" + e.toString());
			return super.onSingleTapConfirmed(e);
		}

    };
    
    @SuppressWarnings("deprecation")
	GestureDetector gestureDetector
    = new GestureDetector(simpleOnGestureListener);
}