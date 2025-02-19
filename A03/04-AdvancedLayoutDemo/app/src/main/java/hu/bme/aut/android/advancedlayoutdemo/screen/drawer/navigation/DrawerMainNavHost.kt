package hu.bme.aut.android.advancedlayoutdemo.screen.drawer.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import hu.bme.aut.android.advancedlayoutdemo.screen.drawer.AboutScreen
import hu.bme.aut.android.advancedlayoutdemo.screen.drawer.HomeScreen
import hu.bme.aut.android.advancedlayoutdemo.screen.drawer.SettingsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerMainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    drawerState: DrawerState,
    startDestination: String = Screen.DrawerScreen.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.DrawerScreen.route) {
            HomeScreen(drawerState)
        }
        composable(Screen.AboutScreen.route) {
            AboutScreen()
        }
        composable(Screen.SettingsScreen.route) {
            SettingsScreen()
        }
    }
}