package hu.bme.aut.android.composeanimationdemo.ui.screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun AnimationScreen3() {

    var toggledPadding by remember {
        mutableStateOf(false)
    }
    val animatedPadding by animateDpAsState(
        if (!toggledPadding) {
            0.dp
        } else {
            20.dp
        }
    )

    val mutableInteractionSource = remember {
        MutableInteractionSource()
    }
    val pressed = mutableInteractionSource.collectIsPressedAsState()
    val elevation = animateDpAsState(
        targetValue = if (pressed.value) {
            32.dp
        } else {
            8.dp
        }, label = "elevation"
    )

    Column {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
                //.fillMaxSize()
                .padding(animatedPadding)
                .background(Color(0xff53D9A1))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    toggledPadding = !toggledPadding
                }
        )

        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .padding(50.dp)
                .weight(1f)
                .fillMaxSize()
                .graphicsLayer {
                    this.shadowElevation = elevation.value.toPx()
                }
                .clickable(interactionSource = mutableInteractionSource, indication = null) {
                }
                .background(Color.Green)
        ) {
        }
    }
}
