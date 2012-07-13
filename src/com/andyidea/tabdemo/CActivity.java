package com.andyidea.tabdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class CActivity extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.webview);
		WebView wv = (WebView) findViewById(R.id.webview);
		wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		WebSettings ws = wv.getSettings();
		ws.setJavaScriptEnabled(true);
		wv.loadUrl("file:///android_asset/www/BoBox/map.html");
	}
	
}
