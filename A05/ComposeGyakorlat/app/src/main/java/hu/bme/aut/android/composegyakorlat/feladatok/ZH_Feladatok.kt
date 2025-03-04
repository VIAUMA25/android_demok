package hu.bme.aut.android.composegyakorlat.feladatok

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hu.bme.aut.android.composegyakorlat.ui.theme.ComposeGyakorlatTheme

@Composable
fun ZH1() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "BME")
        Text(text = "VIK")
        Text(text = "AUT")
    }
}

@Composable
fun ZH2() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(Modifier.weight(1f)) {
            Text(
                text = "1",
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Magenta)
                    .weight(2f)
            )
            Text(
                text = "1",
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Yellow)
                    .weight(1f)
            )
        }
        Row(Modifier.weight(2f)) {
            Text(
                text = "3",
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Green)
                    .weight(1f)
            )
            Text(
                text = "4",
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Red)
                    .weight(2f)
            )
        }
    }
}

@Composable
fun ZH3() {
    Box(
        modifier = Modifier
            .size(400.dp)
            .border(
                width = 2.dp,
                color = Color.Cyan
            )
    ) {
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Text(text = "TopStart")
        }
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text(text = "CenterEnd")
        }
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(text = "BottomCenter")
        }
    }
}

@Composable
fun ZH4() {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {
                Toast.makeText(
                    context,
                    "Clicked",
                    Toast.LENGTH_LONG
                ).show()
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(text = "Vastag szöveg", fontWeight = FontWeight.Bold)
            Text(text = "Piros szöveg", color = Color.Red)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ZH1Preview() {
    ComposeGyakorlatTheme {
        Box(modifier = Modifier.safeDrawingPadding()) {
            ZH1()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ZH2Preview() {
    ComposeGyakorlatTheme {
        Box(modifier = Modifier.safeDrawingPadding()) {
            ZH2()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ZH3Preview() {
    Box(modifier = Modifier.safeDrawingPadding()) {
        ZH3()
    }
}

@Preview(showSystemUi = true)
@Composable
fun ZH4Preview() {
    Box(modifier = Modifier.safeDrawingPadding()) {
        ZH4()
    }
}