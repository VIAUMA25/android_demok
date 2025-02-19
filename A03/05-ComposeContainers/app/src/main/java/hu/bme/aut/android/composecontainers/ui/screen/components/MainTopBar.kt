package hu.bme.aut.android.composecontainers.ui.screen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(title: String){
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(title)},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor =
            MaterialTheme.colorScheme.secondaryContainer
        ),
        navigationIcon = {
            IconButton(
                onClick = {  }
                    ) {
                        Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Drawer Icon")
                    }
                },
        actions = {
            IconButton(
                onClick = { expanded = !expanded}
            ) {
                Icon(Icons.Filled.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false}) {
                DropdownMenuItem(onClick = { },
                    text = { Text(text = "demo") })
                DropdownMenuItem(onClick = { },
                    text = { Text(text = "Settings") })
            }
        }
    )
}