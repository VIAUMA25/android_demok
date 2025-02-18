package hu.bme.aut.android.highlowgamecompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hu.bme.aut.android.highlowgamecompose.ui.screen.game.GameScreen
import hu.bme.aut.android.highlowgamecompose.ui.screen.help.HelpScreen
import hu.bme.aut.android.highlowgamecompose.ui.screen.mainmenu.MainMenuScreen

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "mainmenu"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("mainmenu") {
            MainMenuScreen(
                onNavigateToGame = { navController.navigate("game?upperBound=3") },
                navController
            )
        }
        composable("game?upperBound={upperBound}",
                arguments = listOf(navArgument("upperBound") {
                    defaultValue = 0
                    type = NavType.IntType })
            ) { GameScreen() }
        composable("help/{helptext}?userId={userId}",
            arguments = listOf(navArgument("helptext"){ type = NavType.StringType },
                navArgument("userId") {
                    defaultValue = 0
                    type = NavType.IntType })) { navBackStackEntry ->
            /* Extracting the helptext from the route */
            val text = navBackStackEntry.arguments?.getString("helptext")
            val user = navBackStackEntry.arguments?.getInt("userId")
            /* We check if argument is not null */
            text?.let {
                user?.let {
                    HelpScreen(
                        helpText = text,
                        userId = user
                    )
                }
            }
        }
        composable("about") { HelpScreen() }
    }
}