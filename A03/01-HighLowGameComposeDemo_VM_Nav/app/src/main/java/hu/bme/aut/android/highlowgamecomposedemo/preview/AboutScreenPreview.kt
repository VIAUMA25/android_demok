package hu.bme.aut.android.highlowgamecomposedemo.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import hu.bme.aut.android.highlowgamecomposedemo.screen.about.AboutScreen
import hu.bme.aut.android.highlowgamecomposedemo.ui.theme.HighLowGameComposeDemoTheme

@Preview(showSystemUi = true)
@Composable
fun AboutScreenPreview() {
    HighLowGameComposeDemoTheme {
        AboutScreen()
    }
}