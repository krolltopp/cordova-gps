package com.aquamontes.gps

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

public class Gps extends CordovaPlugin implements LocationListener {

  private static final long MIN_LOCATION_UPDATE_TIME = 10000;
  private static final float MIN_DISTANCE = 50;

  private LocationManager locationManager;
  private Location location;
  private String provider;

  protected void pluginInitialize()
    Criteria criteria = new Criteria();
    criteria.setAccuracy(Criteria.ACCURACY_FINE);
    locationManager = (LocationManager) this.webView.getContext().getSystemService(Context.LOCATION_SERVICE);
    String provider = locationManager.getBestProvider(criteria, false);
  }

  @Override
  public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
    if (action.equals("gpspos")) {

    } else {
      return false;
    }
  }

  @Override
  public void onLocationChanged(Location location) {
    this.location = location;
  }

  @Override
  public void onProviderEnabled(String provider) {

  }

  @Override
  public void onProviderDisabled(String provider) {

  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {

  }

  @Override
  public void onStart() {
    locationManager.requestLocationUpdates(provider,MIN_LOCATION_UPDATE_TIME,  MIN_DISTANCE, this);
    Location location = locationManager.getLastKnownLocation(provider);
  }

  @Override
  public void onStop() {
  }

  @Override
  public void onResume(boolean multitasking) {
    locationManager.requestLocationUpdates(provider,MIN_LOCATION_UPDATE_TIME,  MIN_DISTANCE, this);
  }

  @Override
  public void onPause(boolean multitasking) {
    locationManager.removeUpdates(this);
    Location location = locationManager.getLastKnownLocation(provider);
  }

}
