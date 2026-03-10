package hu.bme.aut.composegyakorlat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.ui.Modifier
import hu.bme.aut.composegyakorlat.ui.feladatok.DropdownMenuDemo
import hu.bme.aut.composegyakorlat.ui.feladatok.LazyColumnDemo
import hu.bme.aut.composegyakorlat.ui.feladatok.ScaffoldDemo
import hu.bme.aut.composegyakorlat.ui.feladatok.SimpleList
import hu.bme.aut.composegyakorlat.ui.feladatok.ZH1
import hu.bme.aut.composegyakorlat.ui.feladatok.ZH2
import hu.bme.aut.composegyakorlat.ui.feladatok.ZH3
import hu.bme.aut.composegyakorlat.ui.feladatok.ZH4
import hu.bme.aut.composegyakorlat.ui.theme.ComposeGyakorlatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeGyakorlatTheme {
                HorizontalPager(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding(),
                    state = rememberPagerState(pageCount = { 8 })
                ) { page ->
                    when (page) {
                        0 -> LazyColumnDemo()
                        1 -> SimpleList()
                        2 -> DropdownMenuDemo()
                        3 -> ScaffoldDemo()
                        4 -> ZH1()
                        5 -> ZH2()
                        6 -> ZH3()
                        7 -> ZH4()
                    }
                }

            }
        }
    }
}