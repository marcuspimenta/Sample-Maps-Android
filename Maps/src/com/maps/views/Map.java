package com.maps.views;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 10:04:02 03/11/2012
 */
public class Map {
	
	private MapView mapa;
	
	public Map(MapView mapa){
		this.mapa = mapa;
	}
	
	public void setZoom(int zoom){
		mapa.getController().setZoom(zoom);
	}
	
	public void configZoom(boolean flag){
    	mapa.setBuiltInZoomControls(flag);
    }
	
	public void centralizaMapaInOnePoint(GeoPoint geoPoint){
		mapa.getController().animateTo(geoPoint);
	}
	
	public void updateMap(){
		mapa.invalidate();
	}

	public MapView getMapa() {
		return mapa;
	}

	public void modoRua(){
		mapa.setSatellite(false);
    	mapa.setStreetView(true);
    	mapa.setTraffic(false);
	}
	
	public void modoSatelete(){
		mapa.setSatellite(true);
    	mapa.setStreetView(false);
    	mapa.setTraffic(false);
	}
	
	public void modoTerreno(){
		mapa.setSatellite(true);
    	mapa.setStreetView(true);
    	mapa.setTraffic(false);
	}
	
	public void clearMapa(){
		mapa.getOverlays().clear();
    }
	
	public void addOverlay(Overlay overlay){
		mapa.getOverlays().add(overlay);
	}
	
	public void removeOverlay(Overlay overlay){
		mapa.getOverlays().remove(overlay);
	}
	
}