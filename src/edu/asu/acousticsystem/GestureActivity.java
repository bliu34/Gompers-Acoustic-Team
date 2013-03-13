package edu.asu.acousticsystems;

import edu.asu.acousticsystems.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;

public class GestureActivity extends Activity {
	
<<<<<<< HEAD
	
	TextView gEvent;
=======
	TextView gestureEvent;
>>>>>>> 5d1d0d9b2565a44b2aaa723527fb4eb690c5678f
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gestureEvent = (TextView)findViewById(R.id.GestureEvent);
    }
    
    @Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
    	return gestureDetector.onTouchEvent(event);
	}

	SimpleOnGestureListener simpleOnGestureListener
    = new SimpleOnGestureListener(){

		@Override
		public boolean onDoubleTap(MotionEvent e) {
			// TODO Auto-generated method stub
			gestureEvent.setText("Double Tap Detected: \n" + e.toString());
			return super.onDoubleTap(e);
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub
			gestureEvent.setText("Swipe Detected: \n" + e1.toString() + "\n" + e2.toString() +"\n" );
			return super.onFling(e1, e2, velocityX, velocityY);
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			gestureEvent.setText("Long Press Detected: \n" + e.toString());
			super.onLongPress(e);
		}

		@Override
		public boolean onSingleTapConfirmed(MotionEvent e) {
			// TODO Auto-generated method stub
			gestureEvent.setText("Single Tap Detected: \n" + e.toString());
			return super.onSingleTapConfirmed(e);
		}

    };
    
    GestureDetector gestureDetector
    = new GestureDetector(simpleOnGestureListener);
}