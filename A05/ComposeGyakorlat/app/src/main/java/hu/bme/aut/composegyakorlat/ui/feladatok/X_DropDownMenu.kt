package hu.bme.aut.composegyakorlat.ui.feladatok

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showSystemUi = true)
fun DropdownMenuDemo() {
    val context = LocalContext.current

    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .wrapContentSize(Alignment.TopEnd)
    ) {
        IconButton(
            onClick = { expanded = !expanded }
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More"
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            for (item in myDropDown) {
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.text
                        )
                    },
                    text = { Text(text = item.text) },
                    onClick = {
                        Toast.makeText(
                            context,
                            "${item.text} clicked",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                )
            }
//            DropdownMenuItem(
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.MailOutline,
//                        contentDescription = ""
//                    )
//                },
//                text = { Text(text = "Save") },
//                onClick = {
//                    Toast.makeText(
//                        context,
//                        "Save clicked",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//            )
//            DropdownMenuItem(
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.PlayArrow,
//                        contentDescription = ""
//                    )
//                },
//                text = { Text(text = "Load") },
//                onClick = {
//                    Toast.makeText(
//                        context,
//                        "Load clicked",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//            )
        }
    }

}

data class MyDropDownMenuItem(
    val text: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)

val myDropDown = arrayListOf(
    MyDropDownMenuItem(
        text = "Save",
        icon = Icons.Default.MailOutline,
        onClick = {}),
    MyDropDownMenuItem(
        text = "Load",
        icon = Icons.Default.PlayArrow,
        onClick = {}),
)