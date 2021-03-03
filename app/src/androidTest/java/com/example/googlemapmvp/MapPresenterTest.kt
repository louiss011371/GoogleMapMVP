package com.example.googlemapmvp

import com.google.android.gms.maps.model.LatLng
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

class MapPresenterTest {
    lateinit var presenter: MapPresenter
    @RelaxedMockK
    lateinit var mMapView : MapContact.mapView

    @RelaxedMockK
    lateinit var repository: MapRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        presenter = MapPresenter(mMapView, repository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    // onMapReady
    @Test
    fun testMapReady() {
        // When
        presenter.onMapReady()
        // Then
        verify {
            repository.loadLocation(presenter)
        }
    }

    // getLocation
    @Test
    fun testGetLocation() {
        // Given
        val mockLocation = Location(33.5, 130.3)
        val mockPlace = "Fukuoka"
        val mockLocationToLatLng = LatLng(mockLocation.lat, mockLocation.lng)
        // When
        presenter.getLocation(mockPlace, mockLocation)
        // Then
        verify {
            mMapView.addScooter(mockPlace, mockLocationToLatLng)
            mMapView.scrollMapTo(mockLocationToLatLng)
        }
    }
}