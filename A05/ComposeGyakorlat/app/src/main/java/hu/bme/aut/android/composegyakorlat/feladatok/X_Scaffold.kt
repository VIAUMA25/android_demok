package hu.bme.aut.android.composegyakorlat.feladatok

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import hu.bme.aut.android.composegyakorlat.ui.theme.ComposeGyakorlatTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold() {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                title = {
                    Text("TopAppBar")
                }, navigationIcon = {
                    Icon(
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = ""
                    )
                },
                actions = {
                    Icon(
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "",
                    )
                }

            )
        },
        bottomBar = {
//            NavigationBar {
//                NavigationBarItem(
//                    selected = false,
//                    onClick = {},
//                    icon = {
//                        Icon(
//                            imageVector = Icons.Default.Call,
//                            contentDescription = ""
//                        )
//                    }
//                )
//                NavigationBarItem(
//                    selected = true,
//                    onClick = {},
//                    icon = {
//                        Icon(
//                            imageVector = Icons.Default.Send,
//                            contentDescription = ""
//                        )
//                    }
//                )
//            }
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = "BottomAppBar",
                    textAlign = TextAlign.Center
                )
            }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {
                    Text(text = "Add")
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = ""
                    )
                },
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                onClick = {
                    scope.launch {
                        snackBarHostState.showSnackbar("Snackbar")
                    }
                },
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(text = "Hello Platformok!")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyScaffoldPreview() {
    ComposeGyakorlatTheme {
        Box() {
            MyScaffold()
        }
    }
}