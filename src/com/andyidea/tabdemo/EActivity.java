package com.andyidea.tabdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class EActivity extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView tv = new TextView(this);
		tv.setText("Hello World!");
		tv.setGravity(Gravity.CENTER);
		setContentView(tv);
	}
	
}
