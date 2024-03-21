package hu.bme.aut.composegyakorlat.feladatok

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListItems(){
    LazyColumn {
        item {
            Text(text = "Lista eleje")
        }
        items(3) { index ->
            Text(text = "Első lista elemei : $index")
        }
        items(5) { index ->
            Text(text = "Második lista elemei: $index")
        }
        item {
            Text(text = "Lista vége")
        }
    }
}

private val cityList =
    mutableListOf("Szeged", "Pécs", "Debrecen", "Budapest")

private val listModifier = Modifier
    .fillMaxSize()
    .background(Color.Gray)
    .padding(10.dp)

private val textStyle = TextStyle(fontSize = 20.sp, color = Color.White)

@Composable
fun SimpleList() {
    LazyColumn(modifier = listModifier) {
        items(cityList) { country ->
            Text(text = country, style = textStyle)
        }
    }
}