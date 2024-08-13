package com.example.pophint

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import kotlinx.coroutines.delay
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Composable
fun PopupHint(
    text: String,
    isShow: MutableState<Boolean>,
    duration: Duration = 1.seconds,
) {
    LaunchedEffect(isShow.value) {
        delay(duration)
        isShow.value = false
    }

    if (isShow.value) {
        Popup(
            onDismissRequest = { isShow.value = false },
            alignment = Alignment.Center,
            properties =
                PopupProperties(
                    excludeFromSystemGesture = true,
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false
                ),
        ) {
            Surface(
                modifier = Modifier.size(width = 150.dp, height = 150.dp)
                    .alpha(0.8F),
                color = Color.Gray,
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = text,
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPopHint() {
    val isShow =
        remember {
            mutableStateOf(true)
        }
    PopupHint(text = "Test", isShow = isShow)
}
