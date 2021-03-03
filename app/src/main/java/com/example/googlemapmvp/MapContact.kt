package com.example.googlemapmvp

import com.google.android.gms.maps.model.LatLng

interface MapContact {

    interface Presenter {
        fun onMapReady()
        fun getLocation(licensePlate: String, location: Location)
    }

    interface Model {
        fun loadLocation(presenter: MapPresenter)
    }

    interface mapView {
        fun addScooter(licensePlate: String, location: LatLng)
        fun scrollMapTo(location: LatLng)
    }
}