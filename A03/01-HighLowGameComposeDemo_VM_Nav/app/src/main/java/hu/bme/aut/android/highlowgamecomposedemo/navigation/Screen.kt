package hu.bme.aut.android.highlowgamecomposedemo.navigation

sealed class Screen(val route: String) {
    companion object {
        const val ARG_UPPERBOUND = "upperBound"
        const val ARG_HELPTEXT = "helptext"
    }

    object MainScreen: Screen("mainscreen")
    object GameScreen : Screen("gamescreen?$ARG_UPPERBOUND={$ARG_UPPERBOUND}"){
        fun createRoute(upperBound: Int) = "gamescreen?$ARG_UPPERBOUND=$upperBound"
    }
    object AboutScreen: Screen("aboutscreen")
    object HelpScreen: Screen("helpscreen/{$ARG_HELPTEXT}") {
        fun createRouter(helpText: String) = "helpscreen/$helpText"
    }
}