package com.example.gallery

import android.net.Uri
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoPlayerScreen(
    uri: String
) {

    val context = LocalContext.current

    val player = remember {

        ExoPlayer.Builder(context).build().apply {

            setMediaItem(
                MediaItem.fromUri(Uri.parse(uri))
            )

            prepare()
            playWhenReady = true
        }
    }

    AndroidView(
        factory = {

            PlayerView(context).apply {
                this.player = player
            }
        }
    )
}