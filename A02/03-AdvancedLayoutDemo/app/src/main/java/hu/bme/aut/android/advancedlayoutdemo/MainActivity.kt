package hu.bme.aut.android.advancedlayoutdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hu.bme.aut.android.advancedlayoutdemo.screen.constraintlayout.ConstraintLayoutDemo
import hu.bme.aut.android.advancedlayoutdemo.screen.constraintlayout.LoginScreen
import hu.bme.aut.android.advancedlayoutdemo.screen.scaffold.ScaffoldDemoScreen
import hu.bme.aut.android.advancedlayoutdemo.ui.theme.AdvancedLayoutDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdvancedLayoutDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Uncomment this to try constraint layout
                    //ConstraintLayoutDemo()
                    //LoginScreen()

                    // Uncomment this to try scaffold layout
                    //ScaffoldDemoScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AdvancedLayoutDemoTheme {
        LoginScreen()
    }
}