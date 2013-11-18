/** ===== LICENSE =====

AWGen by Roberto Pérez Fernández is licensed under a Creative Commons Attribution-Noncommercial-Share Alike 3.0.
Permissions beyond the scope of this license may be available.
The author can be contacted here: http://disastercode.com.es


License details: http://creativecommons.org/licenses/by-nc-sa/3.0/


You are free:

    to Share — to copy, distribute and transmit the work
    to Remix — to adapt the work

Under the following conditions:

    Attribution — You must attribute the work in the manner specified by the author or licensor (but not in any way that suggests 
    			that they endorse you or your use of the work).

    Noncommercial — You may not use this work for commercial purposes.

    Share Alike — If you alter, transform, or build upon this work, you may distribute the resulting work only under the same or 
    			similar license to this one.

With the understanding that:

    Waiver — Any of the above conditions can be waived if you get permission from the copyright holder.
    Public Domain — Where the work or any of its elements is in the public domain under applicable law, that status is in no way 
    			affected by the license.
    Other Rights — In no way are any of the following rights affected by the license:
        Your fair dealing or fair use rights, or other applicable copyright exceptions and limitations;
        The author's moral rights;
        Rights other persons may have either in the work itself or in how the work is used, such as publicity or privacy rights.
    Notice — For any reuse or distribution, you must make clear to others the license terms of this work. The best way to do this 
    	is with a link to this web page.

===== LICENSE ===== */
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
