package com.example.googlemapmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), MapContact.mapView, OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var mapPresenter: MapPresenter
    private var mapRepository: MapRepository ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        mapRepository = MapRepository()
        mapPresenter = MapPresenter(this, mapRepository)

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mapPresenter.onMapReady()
    }

    override fun addScooter(licensePlate: String, location: LatLng) {
        mMap.addMarker(MarkerOptions().position(location).title(licensePlate))
    }

    override fun scrollMapTo(bounds: LatLng) {
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bounds))
    }
}