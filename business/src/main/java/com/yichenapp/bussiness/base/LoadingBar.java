package com.yichenapp.bussiness.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.widget.ImageView;

@SuppressLint("NewApi")
public class LoadingBar extends ImageView implements OnAttachStateChangeListener {
	public final String TAG="LoadingBar";
	protected Resources resource;
	Context context;
	AnimationDrawable anim;
	public LoadingBar(Context context) {
		super(context);
		this.context=context;
		init();
	}
	public LoadingBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context=context;
		init();
	}
	public LoadingBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.context=context;
		init();
	}
	
	@SuppressLint("NewApi")
	private void init(){
		Log.w(TAG, "init");
		resource = context.getResources();
		this.addOnAttachStateChangeListener(this);
		setBackgroundResource(getIdentifierResourceId("animation_loading", "drawable"));
		anim= (AnimationDrawable) getBackground();
		this.post(new Runnable() {
			@Override
			public void run() {

				anim.start();
			}
		});
		
		Log.w(TAG, "anim.start");
	}
	@Override
	public void onViewAttachedToWindow(View arg0) {

		Log.w(TAG, "onViewAttachedToWindow");
//		this.setVisibility(View.VISIBLE);
		
	}
	@Override
	public void onViewDetachedFromWindow(View arg0) {

		Log.w(TAG, "onViewDetachedFromWindow");
//		this.setVisibility(View.GONE);
	}
	@Override
	public void setVisibility(int visibility){
		Log.w(TAG, "setVisibility ="+visibility);
		super.setVisibility(visibility);
	}
	@Override
	protected void onWindowVisibilityChanged(int visibility) {
		Log.w(TAG, "onWindowVisibilityChanged visibility="+visibility);
		super.onWindowVisibilityChanged(visibility);
		if(visibility== View.VISIBLE){
			
		}else if(visibility== View.GONE){
//			anim.stop();
//			Log.w(TAG, "anim.stop");
		}
	}
	public int getIdentifierResourceId(String name, String type) {
		return resource.getIdentifier(name, type, context.getPackageName());
	}
}
