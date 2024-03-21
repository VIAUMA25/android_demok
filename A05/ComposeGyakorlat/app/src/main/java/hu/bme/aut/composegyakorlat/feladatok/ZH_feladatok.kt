package hu.bme.aut.composegyakorlat.feladatok

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.material3.RadioButton
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.remember
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hu.bme.aut.composegyakorlat.R
import hu.bme.aut.composegyakorlat.ui.theme.ComposeGyakorlatTheme

@Composable
fun ZH_CenterColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("BME")
        Text("VIK")
        Text("AUT")
    }
}

@Preview(showBackground = true)
@Composable
fun ZH_CenterColumnPreview() {
    ComposeGyakorlatTheme {
        ZH_CenterColumn()
    }
}

@Composable
fun ZH_RowColumn() {
    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .weight(1f)
        ) {
            Text(
                text = "1",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
                    .background(Color.Magenta)
            )
            Text(
                text = "2",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Yellow)
            )
        }
        Row(Modifier.weight(2f)) {
            Text(
                text = "3",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Green)
            )
            Text(
                text = "4",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
                    .background(Color.Red)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ZH_RowColumnPreview() {
    ComposeGyakorlatTheme {
        ZH_RowColumn()
    }
}

@Composable
fun ZH_Box() {
    Box(
        modifier = Modifier
            .size(400.dp)
            .border(width = 2.dp, color = Color.Cyan)
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

@Preview(showBackground = true)
@Composable
fun ZH_BoxDemo() {
    ComposeGyakorlatTheme {
        ZH_Box()
    }
}

@Composable
fun ZH_Card() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
        )
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text("Vastag szöveg", fontWeight = FontWeight.Bold)
            Text("Piros szöveg", color = Color.Red)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ZH_CardPreview() {
    ComposeGyakorlatTheme {
        ZH_Card()
    }
}



