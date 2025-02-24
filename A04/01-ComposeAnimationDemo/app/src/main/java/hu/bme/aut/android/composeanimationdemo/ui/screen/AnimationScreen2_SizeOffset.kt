package hu.bme.aut.android.composeanimationdemo.ui.screen

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun AnimationScreen2() {
    var sizeState by remember { mutableStateOf(200.dp) }

    val size by animateDpAsState(
        targetValue = sizeState,
        keyframes {
            durationMillis = 5000
            sizeState * 0.8f at 1000 with LinearEasing
            sizeState * 1f at 5000 with FastOutLinearInEasing
        }, label = "size"
    )

    var moved by remember { mutableStateOf(false) }
    val pxToMove = with(LocalDensity.current) {
        100.dp.toPx().roundToInt()
    }
    val offset by animateIntOffsetAsState(
        targetValue = if (moved) {
            IntOffset(pxToMove, pxToMove)
        } else {
            IntOffset.Zero
        }
    )


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = { sizeState += 50.dp }) {
            Text(text = "Increase")
        }
        Box(
            modifier = Modifier
                .size(size)
                .background(Color.Green)
        )

        Button(
            onClick = { moved = !moved },
            modifier = Modifier
                .offset {
                    offset
                }
                .indication(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                )
        ) { Text(text = "Offset animation demo") }

        var toggled by remember { mutableStateOf(false) }
        val offsetTarget = if (toggled) {
            IntOffset(150, 150)
        } else {
            IntOffset.Zero
        }
        val boxOffset = animateIntOffsetAsState(
            targetValue = offsetTarget, label = "offset"
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .clickable {
                    toggled = !toggled
                }
            .layout { measurable, constraints ->
                val offsetValue = if (isLookingAhead) offsetTarget else boxOffset.value
                val placeable = measurable.measure(constraints)
                layout(placeable.width + offsetValue.x, placeable.height + offsetValue.y) {
                    placeable.placeRelative(offsetValue)
                }
            }
            .size(100.dp)
            .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
        )
    }
}


