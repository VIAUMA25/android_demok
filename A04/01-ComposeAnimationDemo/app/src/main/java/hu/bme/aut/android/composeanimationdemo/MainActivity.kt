package hu.bme.aut.android.composeanimationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import hu.bme.aut.android.composeanimationdemo.ui.component.MovieHead
import hu.bme.aut.android.composeanimationdemo.ui.screen.AnimationScreen1
import hu.bme.aut.android.composeanimationdemo.ui.screen.AnimationScreen2
import hu.bme.aut.android.composeanimationdemo.ui.screen.AnimationScreen3
import hu.bme.aut.android.composeanimationdemo.ui.screen.AnimationScreen4
import hu.bme.aut.android.composeanimationdemo.ui.screen.AnimationScreen5
import hu.bme.aut.android.composeanimationdemo.ui.theme.ComposeAnimationDemoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimationDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val pagerState = rememberPagerState(pageCount = {
                        6
                    })
                    HorizontalPager(state = pagerState) { page ->
                        // Our page content
                        when (page) {
                            0 -> MovieHead(
                                name = "Forrest Gump",
                                year = "1994",
                                imageId = R.drawable.movie
                            ) // expand: size change
                            1 -> AnimationScreen1() // visibility, background color
                            2 -> AnimationScreen2() // size change, x-y offset
                            3 -> AnimationScreen3() // padding and elevation animations
                            4 -> AnimationScreen4() // text scale and color
                            5 -> AnimationScreen5() // content
                        }
                    }


                }
            }
        }
    }
}