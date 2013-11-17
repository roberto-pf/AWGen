package es.com.disastercode.appwebgenerator.menu;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Html;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.ads.AdView;

import es.com.disastercode.appecodom.R;
import es.com.disastercode.appwebgenerator.MainActivity;


public class MenuActivity extends SherlockActivity{

	protected AdView adView;

    public void onCreate(Bundle savedInstanceState, String titulo, boolean menu) {
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        if(!menu)
        	ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE|ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_HOME_AS_UP);
        ab.setTitle(Html.fromHtml("<font color='#FFFFFF'>"+titulo+"</font>"));

    }
        
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if (item.getItemId() == R.id.menuClosed) {
    		 System.exit(0);
        } else if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
        	return super.onOptionsItemSelected(item);        	
        }
        return true;
    }
    

    
    
    
    public boolean isOnline() {
    	ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

    	NetworkInfo netInfo = cm.getActiveNetworkInfo();

    	if (netInfo != null && netInfo.isConnectedOrConnecting()) {
    		return true;
    	}

    	return false;
    }
    
    
    
    @Override
    public void onDestroy() {
      adView.destroy();
      super.onDestroy();
    }

 
}
