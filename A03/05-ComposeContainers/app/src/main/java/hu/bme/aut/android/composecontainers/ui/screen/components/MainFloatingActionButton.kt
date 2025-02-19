package hu.bme.aut.android.composecontainers.ui.screen.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MainFloatingActionButton(snackbarHostState: SnackbarHostState) {
    val coroutineScope = rememberCoroutineScope()

    FloatingActionButton(
        onClick = {
            coroutineScope.launch {
                val snackbarResult = snackbarHostState.showSnackbar(
                    duration = SnackbarDuration.Short,
                    message = "Item created",
                    actionLabel = "Undo"
                )
                when (snackbarResult) {
                    SnackbarResult.Dismissed -> { }
                    SnackbarResult.ActionPerformed -> { }
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.secondary,
        shape = RoundedCornerShape(16.dp),
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = "Add FAB",
            tint = androidx.compose.ui.graphics.Color.White,
        )
    }
}