package com.example.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import coil.compose.rememberAsyncImagePainter

@Composable
fun ViewerScreen(
    item: MediaFile
) {

    var scale by remember { mutableStateOf(1f) }

    Image(
        painter = rememberAsyncImagePainter(item.uri),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .pointerInput(Unit) {

                detectTransformGestures { _, _, zoom, _ ->
                    scale *= zoom
                }
            }
    )
}