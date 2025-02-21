package hu.bme.aut.android.composeviewinteropdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.ViewCompositionStrategy
import hu.bme.aut.android.composeviewinteropdemo.databinding.ActivityLaunchBinding
import hu.bme.aut.android.composeviewinteropdemo.ui.theme.ComposeViewInteropDemoTheme

class LaunchActivity : AppCompatActivity() {

    lateinit var binding: ActivityLaunchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        binding.composeView.setContent {
            ComposeViewInteropDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoItems("Title")
                }
            }
        }
    }
}

@Composable
fun DemoItems(title: String) {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ) {
        Text(text = "Hello $title!")
        Button(onClick = {
            context.startActivity(Intent(context,
                MainActivity::class.java))
        }) {
            Text(text = "Navigate to main")
        }

        repeat(15) {
            Text(
                "Demo item $it",
                modifier = Modifier.background(androidx.compose.ui.graphics.Color.Green,
                    RectangleShape)
            )
        }
    }

}