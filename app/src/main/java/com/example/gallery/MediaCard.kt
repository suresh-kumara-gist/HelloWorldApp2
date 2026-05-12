package com.example.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun MediaCard(
    item: MediaFile,
    selected: Boolean,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .padding(2.dp)
            .aspectRatio(1f)
            .border(
                width = if (selected) 3.dp else 0.dp,
                color = Color.Blue,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                onClick()
            }
    ) {

        Image(
            painter = rememberAsyncImagePainter(item.uri),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}