package hu.bme.aut.android.highlowgamecomposedemo.preview;

import androidx.compose.runtime.Composable;
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview;
import androidx.navigation.NavController
import hu.bme.aut.android.highlowgamecomposedemo.ui.theme.HighLowGameComposeDemoTheme
import hu.bme.aut.highlowgamecomposedemo.screen.mainmenu.MainMenuScreen

@Preview(showSystemUi = true)
@Composable
fun MainMenuScreenPreview() {
    HighLowGameComposeDemoTheme {
        MainMenuScreen(
            onNavigateToGame = {},
            onNavigateToHelp = {},
            navController = NavController(
                LocalContext.current
            )
        )
    }
}