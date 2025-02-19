package hu.bme.aut.android.composecontainers.ui.screen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun BottomBar() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { },
            label = {
                Text(
                    text = "Home",
                    fontWeight = FontWeight.SemiBold,
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Home,
                    contentDescription = null
                )
            }
        )
        NavigationBarItem(
            selected = true,
            onClick = { },
            label = {
                Text(
                    text = "Add",
                    fontWeight = FontWeight.SemiBold,
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.AddCircle,
                    contentDescription = null
                )
            }
        )
        NavigationBarItem(
            selected = true,
            onClick = { },
            label = {
                Text(
                    text = "Profile",
                    fontWeight = FontWeight.SemiBold,
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Settings,
                    contentDescription = null
                )
            }
        )
    }
}