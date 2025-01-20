package com.thoren.manganimu.core.media.players.ui


import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.ui.PlayerView
import com.thoren.manganimu.core.media.players.MediaPlayerService

@Composable
fun PlayerScreen(mediaUrl: String) {
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = { ctx ->
                PlayerView(ctx).apply {
                    val intent = Intent(ctx, MediaPlayerService::class.java).apply {
                        putExtra("MEDIA_URL", mediaUrl)
                    }
                    ctx.startService(intent)
                }
            },
            modifier = Modifier.fillMaxSize()
        )

        Button(onClick = {
            context.stopService(Intent(context, MediaPlayerService::class.java))
        }) {
            Text("Stop Player")
        }
    }
}