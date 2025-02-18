package hu.bme.aut.android.highlowgamecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hu.bme.aut.android.highlowgamecompose.ui.navigation.MyAppNavHost
import hu.bme.aut.android.highlowgamecompose.ui.theme.HighLowGameComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HighLowGameComposeTheme {
                MyAppNavHost(modifier = Modifier.fillMaxSize())
            }
        }
    }
}