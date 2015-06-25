package com.yu.yuriseviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;


public class SimplePoint extends View{
	private float x;
	private float y;
	private int id;
	
	public SimplePoint(Context context) {
		super(context);
	}
	
	public SimplePoint(Context context,AttributeSet attr){
		super(context, attr);
	}
	
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}


	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setPoint(int id,float x,float y){
		this.id=id;
		this.x=x;
		this.y=y;	
	}
}
