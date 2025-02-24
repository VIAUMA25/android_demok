package hu.bme.aut.android.mapscomposedemo.ui.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyMapViewModel @Inject constructor() : ViewModel() {
    private var _markerPositionList =
        mutableStateListOf<LatLng>()

    fun getMarkersList(): List<LatLng> {
        return _markerPositionList
    }

    fun addMarkerPosition(latLng: LatLng) {
        _markerPositionList.add(latLng)
    }


}