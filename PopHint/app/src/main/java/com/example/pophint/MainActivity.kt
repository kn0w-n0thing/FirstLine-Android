package com.example.pophint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.pophint.ui.theme.PopHintTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isShowPopup = remember { mutableStateOf(false) }
            var popupMessage by remember { mutableStateOf("") }
            PopHintTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        PopupHint(text = popupMessage, isShow = isShowPopup)

                        Button(onClick = {
                            isShowPopup.value = true
                            popupMessage = "Hello world"
                        }) {
                            Text(text = "Show Popup")
                        }
                    }
                }
            }
        }
    }
}
