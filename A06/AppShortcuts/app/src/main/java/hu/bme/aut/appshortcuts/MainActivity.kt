package hu.bme.aut.appshortcuts

import android.app.PendingIntent
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hu.bme.aut.appshortcuts.ui.theme.AppShortcutsTheme
import java.util.Arrays

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppShortcutsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            addShortcut()
            addPinnedShortcut()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun addShortcut() {
        val shortcutManager = getSystemService<ShortcutManager>(ShortcutManager::class.java)

        val shortcut = ShortcutInfo.Builder(applicationContext, "aut")
            .setShortLabel("Website")
            .setLongLabel("Open the website")
            .setIcon(Icon.createWithResource(applicationContext, R.drawable.baseline_language_black_24))
            .setIntent(
                Intent(
                    Intent.ACTION_VIEW,
                Uri.parse("https://www.aut.bme.hu/"))
            )
            .build()

        shortcutManager!!.dynamicShortcuts = Arrays.asList(shortcut)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun addPinnedShortcut(){
        val shortcutManager = getSystemService(ShortcutManager::class.java)

        if (shortcutManager!!.isRequestPinShortcutSupported) {
            val pinShortcutInfo = ShortcutInfo.Builder(applicationContext, "aut").build()

            val pinnedShortcutCallbackIntent = shortcutManager.createShortcutResultIntent(pinShortcutInfo)

            val successCallback = PendingIntent.getBroadcast(applicationContext, /* request code */ 0,
                pinnedShortcutCallbackIntent, /* flags */
                PendingIntent.FLAG_IMMUTABLE)

            shortcutManager.requestPinShortcut(pinShortcutInfo,
                successCallback.intentSender)
        }

    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppShortcutsTheme {
        Greeting("Android")
    }
}