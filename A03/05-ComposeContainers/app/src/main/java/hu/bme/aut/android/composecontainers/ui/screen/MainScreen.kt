package hu.bme.aut.android.composecontainers.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hu.bme.aut.android.composecontainers.ui.screen.components.BottomBar
import hu.bme.aut.android.composecontainers.ui.screen.components.MainFloatingActionButton
import hu.bme.aut.android.composecontainers.ui.screen.components.MainTopBar
import hu.bme.aut.android.composecontainers.ui.screen.components.MyNavigationDrawer
import kotlinx.coroutines.launch


@Composable
fun MainScreen() {

    val snackbarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    MyNavigationDrawer(drawerState = drawerState) {
        Scaffold(
            topBar = {
                MainTopBar(title = "Title", onNavigationIconClick = {
                    scope.launch {
                        if (drawerState.isOpen)
                            drawerState.close()
                        else
                            drawerState.open()
                    }
                })
            },
            bottomBar = { BottomBar() },
            floatingActionButton = { MainFloatingActionButton(snackbarHostState) },
            snackbarHost = {
                SnackbarHost(
                    hostState = snackbarHostState
                )
            },

            ) { contentPadding ->
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)) {
                Text(text = "Drawer and Scaffold Demo", modifier = Modifier.align(Alignment.Center))
            }
        }

    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}