package com.example.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun VideosScreen(
    items: List<MediaFile>
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {

        items(items) { item ->

            Column {

                MediaCard(
                    item = item,
                    selected = false,
                    onClick = {
                        // TODO open video player
                    },
                    onLongClick = {
                        // TODO multi-select
                    }
                )

                Text(item.name)
            }
        }
    }
}