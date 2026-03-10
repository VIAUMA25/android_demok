package hu.bme.aut.composegyakorlat.ui.feladatok

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun LazyColumnDemo() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .safeDrawingPadding()
    ) {
        item {
            Text(text = "Lista eleje")
        }
        items(3) { index ->
            Text(text = "Első lista elemei: ${index + 1}")
        }
        items(5) { index ->
            Text(text = "Második lista elemei: ${index + 1}")
        }
        item {
            Text(text = "Lista vége")
        }
    }
}

val cityList = mutableStateListOf(
    "Szeged",
    "Pécs",
    "Debrecen",
    "Budapest"
)

@Preview(showSystemUi = true)
@Composable
fun SimpleList() {

    val backgroundColor = Color.Blue
    val contentColor = Color.Yellow


    val context = LocalContext.current

    val listModifier = Modifier
        .fillMaxSize()
        .safeDrawingPadding()
        .background(backgroundColor)
        .padding(8.dp)

    LazyColumn(
        modifier = listModifier
    ) {
        items(cityList) { city ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable {
                        Toast.makeText(
                            context,
                            "$city clicked", Toast.LENGTH_LONG
                        ).show()
                        cityList.add(city)
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = city,
                    tint = contentColor
                )
                Text(
                    text = city,
                    style = TextStyle(
                        color = contentColor,
                        fontSize = 20.sp
                    )
                )
            }
            if (cityList.indexOf(city) != cityList.size - 1)
                HorizontalDivider(thickness = 4.dp, color = contentColor)
        }
    }
}