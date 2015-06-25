package com.yu.yuriseviewdemo;


public class yuClickPoint{
	private float x;
	private float y;
	private int id;

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
