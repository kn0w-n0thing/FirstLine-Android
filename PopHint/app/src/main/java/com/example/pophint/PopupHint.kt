package jp.co.jcbc.hrms.composable

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay

@Composable
fun PopupHint(text: String?, duration: Duration = 1.seconds) {
    Log.e("hrms", "text: $text")
    var showDialog by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = Unit) {
        delay(duration)
        showDialog = false
    }

    if (showDialog && !text.isNullOrBlank()) {
        Dialog(
            onDismissRequest = { showDialog = false },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Surface(
                modifier = Modifier.size(width = 150.dp, height = 150.dp),
                shape = RoundedCornerShape(16.dp) // Specify any shape you like
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(16.dp)
                ) {
                    // Display circular progress indicator
                    Text(
                        text = text,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPopHint() {
    PopupHint(text = "Test")
}
