package hu.bme.aut.android.tododemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hu.bme.aut.android.tododemo.ui.screen.TodoListScreen
import hu.bme.aut.android.tododemo.ui.screen.TodoSummaryScreen

@Composable
fun TodoAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "todolist"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("todolist") { TodoListScreen(navController = navController) }

        composable("summary/{numalltodo}/{numimportant}",
            arguments = listOf(
                navArgument("numalltodo") { type = NavType.IntType },
                navArgument("numimportant") { type = NavType.IntType }
            )
        ) {
            val numalltodo = it.arguments?.getInt("numalltodo")
            val numimportant = it.arguments?.getInt("numimportant")
            if (numalltodo != null && numimportant != null) {
                TodoSummaryScreen(numalltodo = numalltodo, numimportanttodo = numimportant)
            }
        }
    }
}
