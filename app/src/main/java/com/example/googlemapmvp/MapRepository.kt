package com.example.googlemapmvp

import com.google.android.gms.maps.model.LatLng

class MapRepository : MapContact.Model {
    override fun loadLocation(presenter: MapPresenter) {
        presenter.getLocation("Fukuoka" ,location = Location(33.5, 130.3))
    }
}