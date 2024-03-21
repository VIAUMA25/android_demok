package hu.bme.aut.glancedemo.glance

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.actionStartActivity
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.Text
import hu.bme.aut.glancedemo.MainActivity

class PlatformokWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {

        // In this method, load data needed to render the AppWidget.
        // Use `withContext` to switch to another thread for long running
        // operations.

        provideContent {
            // create your AppWidget here
            PlaformokContent()
        }
    }

    @Composable
    private fun PlaformokContent() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(Color.Cyan),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Melyik oldalt szeretnéd megnyitni?",
                modifier = GlanceModifier.padding(12.dp)
            )

            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    text = "BME AUT",
                    onClick = actionStartActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.aut.bme.hu")))
                )
                Spacer(
                    modifier = GlanceModifier.width(20.dp)
                )
                Button(
                    text = "BME VIK",
                    onClick = actionStartActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.vik.bme.hu")))
                )
            }
        }
    }
}

