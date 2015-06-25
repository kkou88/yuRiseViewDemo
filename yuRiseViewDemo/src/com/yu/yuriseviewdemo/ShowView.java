package com.yu.yuriseviewdemo;

import com.example.yuriseviewdemo.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class ShowView extends SimplePoint {
	private int textcolor = Color.WHITE;
	private String textstring = "ddddddd";
	private int textSize = 18;
	private Paint mPaint;
	private int backgroundcolor = Color.BLUE;
	private float textWidth;
	private int height = 50;
	private int width = 150;
	private int left = 30, top = 50;
	int bottom = height + top;
	int right = width + left;

	public ShowView(Context context) {
		super(context);
	}

	public ShowView(Context context, AttributeSet attr) {
		super(context, attr);
		initview(context, attr);
	}

	private void initview(Context context, AttributeSet attr) {
		mPaint = new Paint();
		TypedArray a = context.obtainStyledAttributes(attr,
				R.styleable.ShowView);
		backgroundcolor = a.getColor(R.styleable.ShowView_BackgroundColor,
				Color.TRANSPARENT);
		textSize = a.getInt(R.styleable.ShowView_textSize, 18);
		textcolor = a.getColor(R.styleable.ShowView_textColor, Color.BLACK);
		a.recycle();
	}

	/**
	 * 初始化位置，大小
	 * @param left
	 * @param top
	 * @param width
	 * @param height
	 */
	public void setlocation(int left, int top, int width, int height) {
		this.width = width;
		this.height = height;
		this.left=left;
		this.top=top;
		bottom = height + top;
		right = width + left;
		postInvalidate(left, top, right, bottom);
	}
	
	/**
	 * 设置风格
	 * @param textsize
	 * @param textcolor
	 * @param backgroundcolor
	 */
	public void setViewStytle(int textsize,int textcolor,int backgroundcolor){
		this.textSize=textsize;
		this.textcolor=textcolor;
		this.backgroundcolor=backgroundcolor;
		postInvalidate();
	}

	@SuppressLint("DrawAllocation")
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// int right = 180, bottom = 90;
		// height = bottom - top;
		// width = right - left;

		if (mPaint == null) {
			mPaint = new Paint();
		}
		mPaint.setColor(backgroundcolor); // 设置背景颜色
		// mPaint.setStyle(Paint.Style.STROKE); // 设置空心，默认为实心
		mPaint.setTextSize(textSize);
		mPaint.setTypeface(Typeface.DEFAULT_BOLD); // 设置字体
		mPaint.setAntiAlias(true); // 消除锯齿
		Rect b = new Rect(left, top, right, bottom);
		canvas.drawRect(b, mPaint);
		textWidth = mPaint.measureText(textstring); // 测量字体宽度，我们需要根据字体的宽度设置在圆环中间
		mPaint.setStrokeWidth(0);
		mPaint.setColor(textcolor);
		mPaint.setTextSize(textSize);
		mPaint.setTypeface(Typeface.DEFAULT_BOLD); // 设置字体
		canvas.drawText(textstring, (right + left - textWidth) / 2, (bottom
				+ top + textSize) / 2, mPaint); // 画出进度百分比
		b = null;
	}



	public String getTextstring() {
		return textstring;
	}

	public void setTextstring(String textstring) {
		this.textstring = textstring;
		postInvalidate();
	}

	public int getTextSize() {
		return textSize;
		
	}

	public void setTextSize(int textSize) {
		this.textSize = textSize;
		postInvalidate();
	}

	public int getColor() {
		return textcolor;
	}

	public void setColor(int color) {
		this.textcolor = color;
		postInvalidate();
	}

}
