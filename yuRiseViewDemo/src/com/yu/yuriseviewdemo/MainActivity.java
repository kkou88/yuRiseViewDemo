package com.yu.yuriseviewdemo;

import com.example.yuriseviewdemo.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnTouchListener,YuViewAnimation.ThreadDownListener {

	private RelativeLayout mLayout;
	boolean mswitch = false;
	YuViewAnimation ab,cd;
	boolean threaddown=true;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLayout = (RelativeLayout) findViewById(R.id.mytest);
		ab = new YuViewAnimation(getApplicationContext(), mLayout, 400, 60,
				500, 600);
		cd= new YuViewAnimation(getApplicationContext(), mLayout, 400, 80,
				500, 600);
		ab.setThreadDownListener(this);
		mLayout.setOnTouchListener(this);
	}

	public void mswitch(View v) {
//		if (mswitch == false) {
//			ab.startAnimation();
//			mswitch = true;
//		} else {
//			ab.stopAnimation();
//			mswitch = false;
//		}

	}

	@SuppressLint("NewApi")
	@Override
	public boolean onTouch(View v, MotionEvent ev) {
		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
//			if (threaddown) {
//				ab.setX((int)ev.getX());
//				ab.setY((int)ev.getY());
//				ab.startAnimation();
//			}
			
			if (mswitch == false) {
				ab.setX((int)ev.getX()-100);
				ab.setY((int)ev.getY());
				ab.startAnimation();
				mswitch = true;
			} else {
				cd.setX((int)ev.getX()-100);
				cd.setY((int)ev.getY());
				cd.startAnimation();
				mswitch = false;
			}
			
//			ab.setX((int)ev.getX());
//			ab.setY((int)ev.getY());
//			ab.startAnimation();
			break;
		case MotionEvent.ACTION_UP:
			break;
		case MotionEvent.ACTION_MOVE:
			break;
		default:
			break;
		}

		return false;
	}

	@Override
	public void onthreaddown(int threadid, boolean threaddown) {
		this.threaddown=threaddown;
	}

}
