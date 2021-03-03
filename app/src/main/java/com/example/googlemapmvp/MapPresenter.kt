package com.example.googlemapmvp

import com.google.android.gms.maps.model.LatLng

class MapPresenter(view: MapContact.mapView, val repository: MapRepository?): MapContact.Presenter {

    val mapMapView : MapContact.mapView ?= view
    override fun onMapReady() {
        repository?.loadLocation(this)
    }
    override fun getLocation(licensePlate: String, location: Location) {
        val locationToLatLng = LatLng(location.lat, location.lng)
        mapMapView?.addScooter(licensePlate, locationToLatLng)
        mapMapView?.scrollMapTo(locationToLatLng)
    }
}