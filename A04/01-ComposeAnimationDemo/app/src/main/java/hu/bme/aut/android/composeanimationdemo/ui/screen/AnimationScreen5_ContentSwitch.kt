package hu.bme.aut.android.composeanimationdemo.ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class UiState { Loading, Loaded, Error }

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationScreen5() {
    var state by remember {
        mutableStateOf(UiState.Loading)
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(32.dp)
            .fillMaxSize()
    ) {
        AnimatedContent(
            state,
            transitionSpec = {
                fadeIn(
                    animationSpec = tween(3000)
                ) with fadeOut(animationSpec = tween(3000))
            },
            modifier = Modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                state = when (state) {
                    UiState.Loading -> UiState.Loaded
                    UiState.Loaded -> UiState.Error
                    UiState.Error -> UiState.Loading
                }
            },
            label = "Animated Content"
        ) { targetState ->
            when (targetState) {
                UiState.Loading -> {
                    CircularProgressIndicator()
                }

                UiState.Loaded -> {
                    Text(
                        modifier = Modifier.background(Color.Yellow),
                        text = "Completed",
                        fontSize = 24.sp
                    )
                }

                UiState.Error -> {
                    Text(
                        modifier = Modifier.background(Color.Green),
                        text = "Error",
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}