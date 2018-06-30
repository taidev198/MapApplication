package com.example.traig.mapapplication.fragment;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import static android.content.ContentValues.TAG;

/**
 * @author traig on 6/21/2018.
 * @project MapApplication
 */
public class MapFragmentHelper extends SupportMapFragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnInfoWindowClickListener,
        GoogleMap.OnMapLongClickListener,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMarkerClickListener {


    private GoogleApiClient mGoogleApiClient;
    private Location mCurrentLocation;//save current location

    private final int[] MAP_TYPES = {GoogleMap.MAP_TYPE_SATELLITE,//displays a satellite view of the area without street names or labels.
            GoogleMap.MAP_TYPE_NORMAL,//shows a generic map with street names and labels.
            GoogleMap.MAP_TYPE_HYBRID,//Combines satellite and normal mode, displaying satellite images of an area with all labels.
            GoogleMap.MAP_TYPE_TERRAIN,//
            GoogleMap.MAP_TYPE_NONE};
    private int curMapTypeIndex = 0;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {//create GoogleApiClient
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        initListeners();
    }


    private void initListeners() {

//        .setOnMarkerClickListener(this);
//        getMap().setOnMapLongClickListener(this);
//        getMap().setOnInfoWindowClickListener( this );
//        getMap().setOnMapClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }
    

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d(TAG, "onConnected: ");
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public void onMapClick(LatLng latLng) {
        Log.d(TAG, "onMapClick: ");
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        Log.d(TAG, "onMapLongClick: ");
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
