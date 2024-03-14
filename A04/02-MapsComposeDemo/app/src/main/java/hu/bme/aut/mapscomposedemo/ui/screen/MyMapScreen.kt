package hu.bme.aut.mapscomposedemo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch
import java.util.Random

@Composable
fun MyMapScreen(
    viewModel: MyMapViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var uiSettings by remember {
        mutableStateOf(
            MapUiSettings(
                zoomControlsEnabled = true,
                zoomGesturesEnabled = true
            )
        )
    }
    var mapProperties by remember {
        mutableStateOf(
            MapProperties(
                mapType = MapType.NORMAL,
                isTrafficEnabled = false,
                mapStyleOptions = MapStyleOptions.loadRawResourceStyle(context,
                    hu.bme.aut.mapscomposedemo.R.raw.mymapstyle)
            )
        )
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        var cameraState = rememberCameraPositionState {
            CameraPosition.fromLatLngZoom(LatLng(47.0, 19.0), 10f)
        }

        var isSatellite by remember {
            mutableStateOf(false)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = isSatellite,
                onCheckedChange = {
                    isSatellite = it
                    mapProperties = mapProperties.copy(
                        mapType = if (isSatellite) MapType.SATELLITE else MapType.NORMAL
                    )
                },
            )
            Text(text = "Satellite")
        }
        var isTraffic by remember {
            mutableStateOf(false)
        }
        Row(verticalAlignment = Alignment.CenterVertically)  {
            Switch(
                checked = isTraffic,
                onCheckedChange = {
                    isTraffic = it
                    mapProperties = mapProperties.copy(
                        isTrafficEnabled = isTraffic
                    )
                }
            )
            Text(text = "Traffic")
        }

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraState,
            uiSettings = uiSettings,
            properties = mapProperties,
            onMapClick = {
                viewModel.addMarkerPosition(it)

                val random = Random(System.currentTimeMillis())
                val cameraPostion = CameraPosition.Builder()
                    .target(it)
                    .zoom(1f + random.nextInt(5))
                    .tilt(30f + random.nextInt(15))
                    .bearing(-45f + random.nextInt(90))
                    .build()
                //cameraState.position = cameraPostion
                coroutineScope.launch {
                    cameraState.animate(
                        CameraUpdateFactory.newCameraPosition(cameraPostion),3000
                    )
                }
            }
        ) {
            // Add items like Marker-s, Polylines, etc.
            for (position in viewModel.getMarkersList()) {
                Marker(
                    state = MarkerState(position = position),
                    title = "Title"
                )
            }

            Polyline(
                points = listOf(
                    LatLng(47.0, 19.0),
                    LatLng(45.0, 18.0),
                    LatLng(49.0, 23.0),
                ),
                color = androidx.compose.ui.graphics.Color.Red,
                visible = true,
                width = 10f
            )


        }


    }
}