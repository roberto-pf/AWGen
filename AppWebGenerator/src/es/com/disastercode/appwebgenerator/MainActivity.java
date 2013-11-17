package es.com.disastercode.appwebgenerator;

import com.actionbarsherlock.view.MenuInflater;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.actionbarsherlock.view.Menu;
import com.google.ads.AdRequest;
import com.google.ads.AdView;

import es.com.disastercode.appecodom.R;
import es.com.disastercode.appwebgenerator.menu.MenuActivity;

public class MainActivity extends MenuActivity {
    
	private WebView mWebView;
	protected AdView adView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,this.getResources().getString(R.string.TITLE_APP),true);
        setContentView(R.layout.activity_main);
        
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.getSettings().setSupportZoom(true);
//        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setWebViewClient(new MyWebViewClient());
        
        if(isOnline()){
        	mWebView.loadUrl(this.getResources().getString(R.string.URL_DIR));
        }else{
        	mWebView.loadUrl("file:///android_asset/noInternet.html");
        }
        
        adView = (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest();
//        adRequest.addTestDevice(AdRequest.TEST_EMULATOR);              
//        adRequest.addTestDevice("TEST_DEVICE_ID"); 
        adView.loadAd(adRequest);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    
    
    private class MyWebViewClient extends WebViewClient {
    	private ProgressDialog progreso;
    	
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(isOnline()){
	        	progreso = ProgressDialog.show(MainActivity.this,"",view.getContext().getResources().getString(R.string.descargaWeb),true);
	        	progreso.setCancelable(true);
	        	view.loadUrl(url); 
            }else{
            	mWebView.loadUrl("file:///android_asset/noInternet.html");
            }
            return true;
        }
        
        @Override
        public void onPageFinished(WebView view, String url) {
            if (progreso!=null && progreso.isShowing()) {
            	progreso.dismiss();
            }
        }
    }

}
