package com.yu.yuriseviewdemo;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;

public class YuViewAnimation implements Runnable {
	public ThreadDownListener threadDownListener=null;
	RelativeLayout  parent;
	private int x;
	private int y;
	private Context context;
	ArrayList<ViewType> a = new ArrayList<ViewType>();
	private boolean open = false;
	Handler myyHandler;
	boolean threaddown=false;
	int threadid = 3;             //妗嗙殑鏁伴噺锛屽墠浜斾釜鏍峰紡浠ｇ爜宸叉湁锛屽彲淇敼
	ShowView[] mm = new ShowView[threadid];
	
	private int item = 64;//甯ф暟锛屾暟鍊艰秺澶ц秺缁嗚吇
	public int speed=7;//鍊艰秺灏忚秺蹇紝0-30锛�
	public int slu=4;//浣嶇Щ閫熷害锛屽�瓒婂皬瓒婃祦鐣�
	public int jiange=190;//妗嗕笌妗嗕箣闂寸殑闂撮殧
	private int width=200;//妗嗙殑瀹藉害
	private int height=60;//瀹界殑楂樺害

	public YuViewAnimation(Context context, RelativeLayout parent, int width,
			int height, int x, int y) {

//		System.out.println("---->>>鏋勯�鏂规硶瀹炵幇锛�);// 娴嬭瘯璇彞

		this.parent = parent;
		this.setWidth(width);
		this.setHeight(height);
		this.setX(x);
		this.setY(y);
		this.context = context;
		initview();
	}

	public void initview() {
//		System.out.println("---->>>鍒濆鍖朧iew瀹炵幇锛�);// 娴嬭瘯璇彞
//		mLayout = new RelativeLayout(context);
//		my = new RelativeLayout.LayoutParams(width, height);
//		my.setMargins((x - (width / 2)), y - height, 0, 0);
//		mLayout.setLayoutParams(my);
		myyHandler = new Handler() {
			@SuppressLint("NewApi")
			public void handleMessage(android.os.Message msg) {
				switch (msg.arg1) {
				case 0:
					mm[0].setAlpha(alpha[0]);
					break;
				case 1:
					mm[1].setAlpha(alpha[1]);
					break;
				case 2:
					mm[2].setAlpha(alpha[2]);
					break;
				case 3:
					mm[3].setAlpha(alpha[3]);
					break;
				case 4:
					mm[4].setAlpha(alpha[4]);
					break;
				default:
					break;
				}

			}
		};
		setdata(threadid);
		initthread();
	}

	private void initthread() {
		for (int i = 0; i < threadid; i++) {
			changeview(i);
		}
	}

	

	public ArrayList<ViewType> setdata(int n) {
		ViewType viewtype;
//		System.out.println("---->>>鍒濆鍖朌ata瀹炵幇锛�);// 娴嬭瘯璇彞
		for (int i = 0; i < n; i++) {
			viewtype = new ViewType();
			viewtype.setBackgroundcolor(getbgcolor(i));
			viewtype.setTextcolor(getcolor(i));
			viewtype.setTextSize(48);
			viewtype.setAlp((200 / n) * i);
			viewtype.setTextstring("^15987^");
			a.add(viewtype);
		}
		return a;
	}

	public int getbgcolor(int i) {
		int mycolor = Color.GRAY;
		switch (i) {
		case 0:
//			mycolor = Color.GREEN;//绗竴涓鐨勮儗鏅鑹�
			mycolor = Color.TRANSPARENT;//绗竴涓鐨勮儗鏅鑹�
			break;
		case 1:
//			mycolor = Color.BLUE;//绗簩涓鐨勮儗鏅鑹�
			mycolor = Color.TRANSPARENT;//绗竴涓鐨勮儗鏅鑹�
			break;
		case 2:
//			mycolor = Color.GRAY;//绗笁涓鐨勮儗鏅鑹�
			mycolor = Color.TRANSPARENT;//绗竴涓鐨勮儗鏅鑹�
			break;
		case 3:
			mycolor = Color.CYAN;//绗洓涓鐨勮儗鏅鑹�
			break;
		case 4:
			mycolor = Color.RED;
			break;
		default:
			mycolor = Color.RED;
			break;
		}
		return mycolor;
	}

	public int getcolor(int i) {
		int mycolor = Color.GRAY;
		switch (i) {
		case 0:
			mycolor = Color.BLUE;//绗竴涓瓧浣撻鑹�
			break;
		case 1:
			mycolor = Color.YELLOW;//绗簩涓瓧浣撻鑹�
			break;
		case 2:
			mycolor = Color.GREEN;//绗笁涓瓧浣撻鑹�
			break;
		case 3:
			mycolor = Color.RED;//绗洓涓鐨勫瓧浣撻鑹�
			break;
		case 4:
			mycolor = Color.CYAN;
			break;
		default:
			mycolor = Color.GREEN;
			break;
		}
		return mycolor;
	}

	private float alpha[] = new float[threadid];

	@SuppressLint("NewApi")
	public void run() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					animationthread[] aa = new animationthread[threadid];
					for (int i = 0; i < threadid; i++) {
						aa[i] = new animationthread();
						aa[i].setanimation(mm[i], i, item, x, y, width, height);
						aa[i].start();
						Thread.sleep(jiange);
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		System.out.println("finish!");
	}

	class animationthread extends Thread {
		ShowView sv = null;
		int mythreadid = 0;
		int myitem = 0;
		int x, y, width, height;

		public void setanimation(ShowView sv, int threadid, int item, int x,
				int y, int width, int height) {
			this.sv = sv;
			this.mythreadid = threadid;
			this.myitem = item;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}

		public void run() {
			if (threadDownListener!=null) {
				threaddown=false;
				threadDownListener.onthreaddown(mythreadid,threaddown);
			}
			int k = 0;
			Message abc = null;
			boolean op = true;
			while (op) {
				try {
					sv.setlocation(x, (y - (k * slu)), width, height);// 300,500,200,60
					alpha[mythreadid] = (float) (((float) (myitem - k)) / myitem);
					sv.setTextstring("alpha:");
					abc = new Message();
					abc.arg1 = mythreadid;
					myyHandler.sendMessage(abc);
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				k++;
				if (k > myitem) {
					op = false;
				}
			}
			if (mythreadid == threadid) {
				clear();
			}
			if (threadDownListener!=null) {
				threaddown=true;
				threadDownListener.onthreaddown(mythreadid,threaddown);
			}
		}
	}
	
	public interface ThreadDownListener {
		void onthreaddown(int threadid,boolean threaddown);
	}
	
	public void setThreadDownListener(ThreadDownListener threadDownListener) {
		this.threadDownListener = threadDownListener;
	}
	
	

	@SuppressLint("NewApi")
	public void changeview(int i) {
		if (mm[i] == null) {
			mm[i] = new ShowView(context);
		}
		mm[i].setlocation(x, y, width, height);
		mm[i].setViewStytle(a.get(i).getTextSize(), a.get(i).getTextcolor(), a
				.get(i).getBackgroundcolor());
		mm[i].setAlpha(0);
		mm[i].setTextstring(a.get(i).getTextstring());
		mm[i].setTextSize(a.get(i).getTextSize());
		parent.addView(mm[i]);
		// parent.postInvalidate();
	}

	public void stopAnimation() {
		open = false;
		// run();
	}

	public void startAnimation() {
		open = true;
		run();
	}

	public void clear() {
		for (int i = 0; i < item; i++) {
			if (mm[i] != null) {
				mm[i] = null;
			}
		}
//		if (mLayout != null) {
//			mLayout = null;
//		}
		if (a.size() != 0) {
			a.clear();
		}
//		if (my != null) {
//			my = null;
//		}
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getlayoutWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getlayoutHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
