package hu.bme.aut.android.basiclayoutdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hu.bme.aut.android.basiclayoutdemo.ui.theme.BasicLayoutDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicLayoutDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //ColumnDemo()
                    //VerticalDemo()
                    //RowDemo()
                    //ColumnWeightDemo()
                    ScrollColumnDemo()
                    //BoxDemo()
                    //Movie()
                }
            }
        }
    }
}

@Composable
fun ColumnDemo() {
    Column {
        Text(text = "Forrest Gump")
        Text(text = "1994")
    }
}

@Composable
fun VerticalDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(width = 1.dp, color = Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Forrest Gump")
        Text(text = "1994")
        Text(text = "Movie")
    }
}

@Composable
fun RowDemo() {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.forrestgump),
            contentDescription = "Forrest Gump",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Column {
            Text(text = "Forrest Gump")
            Text(text = "1994")
        }
    }
}

@Composable
fun ColumnWeightDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(width = 1.dp, color = Color.Blue),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "Forrest Gump",
            modifier = Modifier
                .weight(1.0f)
                .fillMaxWidth()
                .background(Color.Blue))
        Text(text = "1994",
            modifier = Modifier
                .weight(1.0f)
                .fillMaxWidth()
                .background(Color.Yellow))
        Text(text = "Movie",
            modifier = Modifier
                .weight(1.0f)
                .fillMaxWidth()
                .background(Color.Blue))
    }
}

@Composable
private fun ScrollColumnDemo() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        repeat(100) {
            Text("Item $it", modifier = Modifier.padding(2.dp))
        }
    }
}

@Composable
fun BoxDemo() {
    Box(
        modifier = Modifier
            .size(400.dp)
            .border(width = 2.dp, color = Color.Magenta)
    ) {
        Image(
            painter = painterResource(id = R.drawable.forrestgump),
            contentDescription = "Forrest Gump",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )

        Text(
            text = "TopStart",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Text(
            text = "TopCenter",
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Text(
            text = "TopEnd",
            modifier = Modifier.align(Alignment.TopEnd)
        )

        Text(
            text = "CenterStart",
            modifier = Modifier.align(Alignment.CenterStart)
        )
        Text(
            text = "CenterEnd",
            modifier = Modifier.align(Alignment.CenterEnd)
        )
        Text(
            text = "Center",
            modifier = Modifier.align(Alignment.Center)
        )

        Text(
            text = "BottomStart",
            modifier = Modifier.align(Alignment.BottomStart)
        )
        Text(
            text = "BottomEnd",
            modifier = Modifier.align(Alignment.BottomEnd)
        )
        Text(
            text = "BottomCenter",
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Movie() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable(onClick = {})
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.forrestgump),
                contentDescription = "Forrest Gump",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(text = "Forrest Gump")
                Text(text = "1994")
            }
        }
        Spacer(Modifier.size(10.dp))
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8. dp,
                pressedElevation = 2. dp,
                focusedElevation = 4. dp
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.running),
                contentDescription = "Forrest Gump",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnDemoPreview() {
    BasicLayoutDemoTheme {
        ColumnDemo()
    }
}

@Preview(showBackground = true)
@Composable
fun VerticalDemoPreview() {
    BasicLayoutDemoTheme {
        VerticalDemo()
    }
}

@Preview(showBackground = true)
@Composable
fun RowDemoPreview() {
    BasicLayoutDemoTheme {
        RowDemo()
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnWeightDemoPreview() {
    BasicLayoutDemoTheme {
        ColumnWeightDemo()
    }
}

@Preview(showBackground = true)
@Composable
fun ScrollColumnDemoPreview() {
    BasicLayoutDemoTheme {
        ScrollColumnDemo()
    }
}

@Preview(showBackground = true)
@Composable
fun BoxDemoPreview() {
    BasicLayoutDemoTheme {
        BoxDemo()
    }
}

@Preview(showBackground = true)
@Composable
fun MoviePreview() {
    BasicLayoutDemoTheme {
        Movie()
    }
}