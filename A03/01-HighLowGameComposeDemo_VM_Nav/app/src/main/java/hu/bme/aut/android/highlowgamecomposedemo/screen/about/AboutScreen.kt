package hu.bme.aut.android.highlowgamecomposedemo.screen.about

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    aboutText: String = "Demo app for Jetpack Compose"
) {
    Text(text = aboutText)
}

