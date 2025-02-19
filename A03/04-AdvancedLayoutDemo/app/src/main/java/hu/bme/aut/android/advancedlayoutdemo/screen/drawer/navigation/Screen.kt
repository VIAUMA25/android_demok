package hu.bme.aut.android.advancedlayoutdemo.screen.drawer.navigation

sealed class Screen(val route: String) {
    object DrawerScreen : Screen("drawerscreen")
    object AboutScreen : Screen("aboutscreen")
    object SettingsScreen : Screen("settingsscreen")
}