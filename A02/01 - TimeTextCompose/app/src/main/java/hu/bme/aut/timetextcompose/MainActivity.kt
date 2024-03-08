package hu.bme.aut.timetextcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import java.util.Date
import hu.bme.aut.timetextcompose.ui.theme.TimeTextComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeTextComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TimeTextScreen()
                }
            }
        }
    }
}

@Composable
fun TimeTextScreen(modifier: Modifier = Modifier) {
    var timeText by rememberSaveable { mutableStateOf("-") }
    Column() {
        Text(text = "The current time is: $timeText")
        ClickableText(text = AnnotatedString("current time: $timeText"),
            onClick = { timeText = Date(System.currentTimeMillis()).toString() })
        Button(onClick = {
            timeText = Date(System.currentTimeMillis()).toString()
        }) { Text(text = "Show time") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TimeTextComposeTheme {
        TimeTextScreen()
    }
}