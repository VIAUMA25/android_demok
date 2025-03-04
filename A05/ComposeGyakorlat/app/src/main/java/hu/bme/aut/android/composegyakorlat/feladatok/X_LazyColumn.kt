package hu.bme.aut.android.composegyakorlat.feladatok

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.bme.aut.android.composegyakorlat.ui.theme.ComposeGyakorlatTheme

@Composable
fun ListItems() {
    LazyColumn {
        item {
            Text(text = "Lista eleje")
        }
        items(30) { index ->
            Text(text = "Első lista elemei: ${index + 1}")
        }
        items(50) { index ->
            Text(text = "Második lista elemei: ${index + 1}")
        }
        item {
            Text(text = "Lista vége")
        }
    }
}

private val cityList = mutableListOf("Szeged", "Pécs", "Debrecen", "Budapest")

private val textStyle = TextStyle(
    fontSize = 20.sp,
    color = Color.White
)

@Composable
fun SimpleList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(8.dp)
    ) {
        items(cityList) { city ->
            Column {
                CityListItem(city, textStyle)
                if (cityList.indexOf(city) != cityList.size - 1) {
                    HorizontalDivider(
                        color = Color.White,
                        thickness = 2.dp
                    )
                }
            }
        }
    }
}

@Composable
private fun CityListItem(city: String, style: TextStyle) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast.makeText(
                    context,
                    "$city clicked",
                    Toast.LENGTH_LONG
                ).show()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(4.dp),
            tint = Color.White,
            imageVector = Icons.Default.Home,
            contentDescription = ""
        )
        Text(
            modifier = Modifier.padding(
                top = 8.dp,
                bottom = 8.dp
            ),
            text = city,
            style = style
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ListItemsPreview() {
    ComposeGyakorlatTheme {
        Box(modifier = Modifier.safeDrawingPadding()) {
            ListItems()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SimpleListPreview() {
    ComposeGyakorlatTheme {
        Box(modifier = Modifier.safeDrawingPadding()) {
            SimpleList()
        }
    }
}