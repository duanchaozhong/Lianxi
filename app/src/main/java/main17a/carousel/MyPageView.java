package main17a.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

import com.example.duan.lianxi.AdverInfo;
import com.example.duan.lianxi.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;



/**
 * 自定义pageview
 * 
 * @author
 * 
 */
public  class  MyPageView {

	// 自动轮播的时间间隔
	private final static int TIME_INTERVAL = 5;

	// 放轮播图片的ImageView 的list
	private List<SimpleDraweeView> imageViewsList;
	// 放圆点的View的list
	private List<View> dotViewsList;
	// 服务器获取的数据
	public static ArrayList<String> urlList = new ArrayList<String>();
	// private ChildViewPager viewPager;
	private ChildViewPager viewPager;
	private List<AdverInfo> activityDatas = new ArrayList<AdverInfo>();// 活动列表，用于图片轮播
	private static List<String> list_str = new ArrayList<String>();// 图片列表，用于图片轮播
	// 当前轮播页
	private int currentItem = 0;
	View view;
	public FragmentActivity fragmentActivity;

	// SlideShowTask singleTask;
	boolean isUp = true;

	// Handler用于控制没五秒轮播一次
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == 1) {
				if (!isUp) {
					return;
				}
				currentItem = viewPager.getCurrentItem();
				if (currentItem == Integer.MAX_VALUE) {
					currentItem = -1;
				}
				currentItem++;
				viewPager.setCurrentItem(currentItem);
				currentItem = currentItem % imageViewsList.size();
				int size = dotViewsList.size();
				for (int i = 0; i < size; i++) {
					if (i == currentItem) {
						((View) dotViewsList.get(i))
								.setBackgroundResource(R.drawable.no_selected_dot);
					} else {
						((View) dotViewsList.get(i))
								.setBackgroundResource(R.drawable.selected_dot);
					}
				}
				handler.sendEmptyMessageDelayed(1, TIME_INTERVAL*1000);

			}
		}
	};

	public   MyPageView(View view, FragmentActivity fragmentActivity,
			List<AdverInfo> data, List<String> str) {
		this.view = view;
		this.fragmentActivity = fragmentActivity;
		if (data != null) {
			this.activityDatas = data;
		} else if (str != null) {
			this.list_str = str;
		}

		initData();

		initUI(fragmentActivity);
	}


	public MyPageView (){}
	/**
	 * 初始化相关Data
	 */
	private void initData() {

		imageViewsList = new ArrayList<SimpleDraweeView>();
		dotViewsList = new ArrayList<View>();

	}

	/**
	 * 初始化Views等UI
	 */
	@SuppressLint("ResourceAsColor")
	private void initUI(final Context context) {
		urlList.clear();
		if (activityDatas.size() > 0) {

			for (int i = 0; i < activityDatas.size(); i++) {
				urlList.add(activityDatas.get(i).url);
			}
		} else if (list_str.size() > 0) {

			for (int i = 0; i < list_str.size(); i++) {
				urlList.add(list_str.get(i));
			}
		} else {
			return;
		}

		int size = urlList.size();
		for (int i = 0; i < size; i++) {
			SimpleDraweeView view = new SimpleDraweeView(context);

			/*
			 * 我这边原本加载网络图片用的是imageloader，现在demo直接加载本地图片
			 * ImageLoader.getInstance().displayImage(url, view,
			 * MyApplication.options);
			 */

			view.setImageURI(Uri.parse(urlList.get(i)));

			if (list_str.size() > 0) {
				LayoutParams params = new LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				view.setLayoutParams(params);
				view.setScaleType(ScaleType.FIT_CENTER);
			} else {
				view.setScaleType(ScaleType.FIT_XY);
			}

			imageViewsList.add(view);
		}

		// 设置圆点的大小，可根据需要设置圆点大小与间距
		int y = 18;
		for (int i = 0; i < size; i++) {
			View dotView = new View(context);
			LinearLayout dotarea = (LinearLayout) view.findViewById(R.id.ll_viewarea_dot);
			if (list_str.size() > 0) {
				dotarea.setGravity(Gravity.CENTER_HORIZONTAL);
			}

			if (i > 0) {

				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
						y, y);
				params.setMargins(9, 0, 0, 0);
				dotView.setLayoutParams(params);
				dotView.setBackgroundResource(R.drawable.no_selected_dot);
			} else {
				dotView.setLayoutParams(new LayoutParams(y, y));
				dotView.setBackgroundResource(R.drawable.selected_dot);
			}
			dotarea.addView(dotView);
			dotViewsList.add(dotView);
		}

		viewPager = (ChildViewPager) view.findViewById(R.id.viewPager);

		// 设置滚动效果
		viewPager.setFocusable(true);
		ViewPagerScroller vs = new ViewPagerScroller(context);
		vs.initViewPagerScroll(viewPager);

		viewPager.setAdapter(new MyFragmentPagerAdapter1(fragmentActivity
				.getSupportFragmentManager()));
		viewPager.setOnPageChangeListener(new MyPageChangeListener());
		viewPager.setCurrentItem(size * 100);
		/*
		 * viewPager.setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) { return ; } });
		 */

		viewPager.setOnSingleTouchListener(new ChildViewPager.OnSingleTouchListener() {

			@Override
			public void onTouchUp() {
				setState(true);
			}

			@Override
			public void onTouchDown() {
				// handler.removeCallbacks(singleTask);
				setState(false);
			}

			@Override
			public void onSingleTouch() {
				// TODO 单击事件
		/*		int x = viewPager.getCurrentItem() % (activityDatas.size());
				Intent intent = new Intent(context, ImagePagerActivity.class);
				intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX,x);
				intent.putStringArrayListExtra(ImagePagerActivity.EXTRA_IMAGE_URLS,urlList);
				context.startActivity(intent);*/

			}
		});

		// singleTask = new SlideShowTask();
		// handler.postDelayed(singleTask, 5000);

		handler.sendEmptyMessageDelayed(1, 5000);
	}

	private final class MyFragmentPagerAdapter1 extends
			FragmentStatePagerAdapter {

		public MyFragmentPagerAdapter1(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = new MyFragment();
			Bundle args = new Bundle();
			args.putInt("arg", position);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}
	}

	@SuppressLint("ValidFragment")
	public static class MyFragment extends Fragment {

		@SuppressLint("ResourceAsColor")
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View view = null;
			try {
				view = inflater.inflate(R.layout.pager_item, container, false);
				SimpleDraweeView mImageView = (SimpleDraweeView) view
						.findViewById(R.id.imageView1);
				Bundle args = getArguments();
				final int resId = args.getInt("arg");
				/*imageview加载网络图片
				 * ImageLoader.getInstance()
						.displayImage(
								Tools.getCompleteUrl(urlList.get(resId
										% urlList.size())), mImageView,
								MyApplication.options);*/
				mImageView.setImageURI(Uri.parse(urlList.get(resId % urlList.size())));
//				//demo加载本地图片
//				if (resId% urlList.size()%2==0) {
//					mImageView.setImageResource(R.mipmap.bikewrite);
//				}else {
//					mImageView.setImageResource(R.mipmap.bikewrite);
//				}
				if (list_str.size() > 0) {
					LayoutParams params = new LayoutParams(
							LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT);
					view.setLayoutParams(params);
					mImageView.setScaleType(ScaleType.FIT_CENTER);
				} else {
					mImageView.setScaleType(ScaleType.FIT_XY);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return view;
		}
	}

	/**
	 * ViewPager的监听器 当ViewPager中页面的状态发生改变时调用
	 * 
	 * @author caizhiming
	 */
	private class MyPageChangeListener implements OnPageChangeListener {

		boolean isAutoPlay = false;

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(int pos) {

			// currentItem = pos;
			int size = dotViewsList.size();
			int curPos = pos % size;
			for (int i = 0; i < size; i++) {
				if (i == curPos) {
					((View) dotViewsList.get(i))
							.setBackgroundResource(R.drawable.no_selected_dot);
				} else {
					((View) dotViewsList.get(i))
							.setBackgroundResource(R.drawable.selected_dot);
				}
			}
		}
	}

	/**
	 * 执行轮播图切换任务
	 * 
	 */
	// private class SlideShowTask implements Runnable {
	//
	// @Override
	// public void run() {
	// synchronized (viewPager) {
	// // currentItem = (currentItem + 1) % imageViewsList.size();
	// handler.obtainMessage().sendToTarget();
	// }
	// }
	//
	// }

	/**
	 * 销毁ImageView资源，回收内存
	 * 
	 * @author caizhiming
	 */
	// private void destoryBitmaps() {
	//
	// for (int i = 0; i < urlList.size(); i++) {
	// ImageView imageView = imageViewsList.get(i);
	// Drawable drawable = imageView.getDrawable();
	// if (drawable != null) {
	// // 解除drawable对view的引用
	// drawable.setCallback(null);
	// }
	// }
	// }

	public void setState(boolean b) {
		isUp = b;
		if (!isUp) {
			handler.removeMessages(1);
		} else {
			handler.sendEmptyMessageDelayed(1, 5000);
		}
	}

}
