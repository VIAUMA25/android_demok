package hu.bme.aut.android.composegyakorlat.feladatok

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import hu.bme.aut.android.composegyakorlat.ui.theme.ComposeGyakorlatTheme

@Composable
fun MyDropDownMenu() {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopEnd)
    ) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More options"
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            DropdownMenuItem(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        contentDescription = "Save"
                    )
                },
                text = { Text(text = "Save") },
                onClick = {
                    Toast.makeText(
                        context,
                        "Save clicked",
                        Toast.LENGTH_LONG
                    ).show()
                }
            )
            DropdownMenuItem(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Load"
                    )
                },
                text = { Text(text = "Load") },
                onClick = {
                    Toast.makeText(
                        context,
                        "Load clicked",
                        Toast.LENGTH_LONG
                    ).show()
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DropDownMenuPreview() {
    ComposeGyakorlatTheme {
        Box(modifier = Modifier.safeDrawingPadding()) {
            MyDropDownMenu()
        }
    }
}