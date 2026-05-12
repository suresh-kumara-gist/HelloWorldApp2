package com.example.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun MediaCard(
    item: MediaFile,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp)
    ) {

        Image(
            painter = rememberAsyncImagePainter(item.uri),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}