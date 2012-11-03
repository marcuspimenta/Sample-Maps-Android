package com.maps.activity;

import android.os.Bundle;
import android.view.View;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.maps.R;
import com.maps.notice.Alert;
import com.maps.views.Map;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 09:46:38 03/11/2012
 */
public class MainActivity extends MapActivity {

	private MapView mapView;
	
	private Map map;
	private Alert alert;
	private MyLocationOverlay myLocation;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mapView = (MapView)findViewById(R.id.map);
        
        map = new Map(mapView);
        alert = new Alert(this);
        myLocation = new MyLocationOverlay(MainActivity.this, mapView);
        
        map.configZoom(true);
        map.addOverlay(myLocation);
        
        myLocation.enableMyLocation();
    }
    
    public void onClick(View view) {
		switch (view.getId()) {
			case R.id.mylocation:
				if(myLocation.getMyLocation() != null){
	    			map.centralizaMapaInOnePoint(myLocation.getMyLocation());
	    		}else{
	    			alert.show("Aguardando seu local");
	    		}
				break;
		}
	}
    
    @Override
	protected void onDestroy() {
		super.onDestroy();
		
		myLocation.disableMyLocation();
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}