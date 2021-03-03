package com.example.googlemapmvp

import com.google.android.gms.maps.model.LatLng

class MapRepository : MapContact.Model {
    override fun loadLocation(presenter: MapPresenter) {
        presenter.getLocation("Fukuoka" ,location = Location(35.0, 136.0))
    }
}