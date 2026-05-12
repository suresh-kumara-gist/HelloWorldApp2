package com.example.gallery

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun VideosScreen(
    items: List<MediaFile>
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {

        items(items.size) { index ->

            Column {

                MediaCard(
                    item = items[index]
                ) {}

                Text(items[index].name)
            }
        }
    }
}