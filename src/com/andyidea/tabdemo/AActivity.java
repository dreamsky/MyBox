package com.andyidea.tabdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class AActivity extends Activity{
	
	private WebView wv;
	private Handler mHandler=new Handler();
	private static final String LOG_TAG = "WebViewDemo";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		wv = new WebView(this);
		setContentView(wv);
		// set client
		/*wv.setWebChromeClient(new MyWebChromeClient());*/
		// hide scroll bar
		wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		WebSettings ws = wv.getSettings();
		// enable javascript
		ws.setJavaScriptEnabled(true);
		
		// js call test
		wv.addJavascriptInterface(new Object(){
			public void jsClick(){
				mHandler.post(new Runnable(){
					public void run(){
						wv.loadUrl("javascript:setText('Hello World')");
					}
				});
			}
		}, "demo1");
		
		// js call test
		wv.addJavascriptInterface(new Object(){
			public void javaAlert(){
				mHandler.post(new Runnable(){
					public void run(){
						Toast.makeText(getApplicationContext(), "Demo2:Hello World", 1000).show();
					}
				});
			}
		}, "demo2");		
		
		// load page
		wv.loadUrl("file:///android_asset/www/BoBox/index.html");
	}
	
	/*final class MyWebChromeClient extends WebChromeClient {  
		
        @Override  
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {  
            //Log.d(LOG_TAG, message);  
            //result.confirm();
        	Toast.makeText(getApplicationContext(), message, 1000).show();
            return true;  
        }  
    }*/  

}
