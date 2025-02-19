package hu.bme.aut.android.highlowgamecomposedemo.ui.compose

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import hu.bme.aut.android.highlowgamecomposedemo.R

@Composable
fun SimpleAlertDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = stringResource(R.string.text_congrats)) },
        text = { Text(text = "You have won!") },
        confirmButton = {
            TextButton(onClick = onConfirm)
            { Text(text = "OK") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss)
            { Text(text = "Cancel") }
        }
    )

}