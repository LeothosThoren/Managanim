package com.thoren.manganimu.core.media.players

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import jakarta.inject.Inject

class MediaPlayerService : Service() {

    @Inject
    lateinit var player: ExoPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val mediaUrl = intent?.getStringExtra("MEDIA_URL")
        mediaUrl?.let {
            val mediaItem = MediaItem.fromUri(it)
            player.setMediaItem(mediaItem)
            player.prepare()
            player.playWhenReady = true
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}