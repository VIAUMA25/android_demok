package hu.bme.aut.composegyakorlat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hu.bme.aut.composegyakorlat.feladatok.Demo_DropDownMenu
import hu.bme.aut.composegyakorlat.feladatok.ListItems
import hu.bme.aut.composegyakorlat.feladatok.ScaffoldExample
import hu.bme.aut.composegyakorlat.feladatok.SimpleList
import hu.bme.aut.composegyakorlat.feladatok.SnackbarDemo
import hu.bme.aut.composegyakorlat.feladatok.ZH_Box
import hu.bme.aut.composegyakorlat.feladatok.ZH_Card
import hu.bme.aut.composegyakorlat.feladatok.ZH_CenterColumn
import hu.bme.aut.composegyakorlat.feladatok.ZH_RowColumn
import hu.bme.aut.composegyakorlat.ui.theme.ComposeGyakorlatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeGyakorlatTheme {
                Demo_DropDownMenu()
            }
        }
    }
}