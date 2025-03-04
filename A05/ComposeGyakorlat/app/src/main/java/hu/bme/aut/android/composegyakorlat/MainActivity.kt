package hu.bme.aut.android.composegyakorlat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import hu.bme.aut.android.composegyakorlat.feladatok.ListItems
import hu.bme.aut.android.composegyakorlat.feladatok.SimpleList
import hu.bme.aut.android.composegyakorlat.feladatok.MyDropDownMenu
import hu.bme.aut.android.composegyakorlat.feladatok.MyScaffold
import hu.bme.aut.android.composegyakorlat.feladatok.ZH1
import hu.bme.aut.android.composegyakorlat.feladatok.ZH2
import hu.bme.aut.android.composegyakorlat.feladatok.ZH3
import hu.bme.aut.android.composegyakorlat.feladatok.ZH4
import hu.bme.aut.android.composegyakorlat.ui.theme.ComposeGyakorlatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeGyakorlatTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding()) {
                    ListItems()
//                    SimpleList()
//                    MyDropDownMenu()
//                    MyScaffold()
//                    ZH1()
//                    ZH2()
//                    ZH3()
//                    ZH4()
                }
            }
        }
    }
}