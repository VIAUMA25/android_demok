package hu.bme.aut.android.composecontainers.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import hu.bme.aut.android.composecontainers.ui.screen.components.BottomBar
import hu.bme.aut.android.composecontainers.ui.screen.components.MainFloatingActionButton
import hu.bme.aut.android.composecontainers.ui.screen.components.MainTopBar


@Composable
fun MainScreen() {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = { MainTopBar(title = "Title") },
        bottomBar = { BottomBar() },
        floatingActionButton = { MainFloatingActionButton(snackbarHostState) },
        snackbarHost = { SnackbarHost(
            hostState = snackbarHostState) },
    ) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)) {  }
    }
}