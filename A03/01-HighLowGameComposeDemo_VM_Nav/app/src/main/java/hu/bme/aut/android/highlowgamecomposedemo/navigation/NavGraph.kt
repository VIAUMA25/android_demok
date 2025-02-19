package hu.bme.aut.android.highlowgamecomposedemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hu.bme.aut.android.highlowgamecomposedemo.screen.about.AboutScreen
import hu.bme.aut.android.highlowgamecomposedemo.screen.game.GameScreen
import hu.bme.aut.android.highlowgamecomposedemo.screen.help.HelpScreen
import hu.bme.aut.highlowgamecomposedemo.screen.mainmenu.MainMenuScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.MainScreen.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(Screen.MainScreen.route) {
            MainMenuScreen(
                onNavigateToGame = { navController.navigate(Screen.GameScreen.createRoute(20)) },
                onNavigateToHelp = { navController.navigate(Screen.HelpScreen.createRouter("Use the menu to navigate in the app")) },
                navController
            )
        }
        composable(Screen.GameScreen.route,
            arguments = listOf(navArgument(Screen.ARG_UPPERBOUND) {
                defaultValue = 0
                type = NavType.IntType }
            )
        ) {

            GameScreen()
        }


        composable(Screen.AboutScreen.route) {
            AboutScreen()
        }
        composable(
            Screen.HelpScreen.route,
            arguments = listOf(navArgument(Screen.ARG_HELPTEXT) { type = NavType.StringType })
        ) { navBackStackEntry ->
            /* Extracting the helptext from the route */
            val text = navBackStackEntry.arguments?.getString(Screen.ARG_HELPTEXT)

            text?.let {
                HelpScreen(helpText = text)
            }
        }
    }
}