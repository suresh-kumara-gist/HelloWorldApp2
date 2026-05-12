package com.example.gallery

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable

@Composable
fun PhotosScreen(
    items: List<MediaFile>,
    onOpen: (Int) -> Unit
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {

        items(items.size) { index ->

            MediaCard(
                item = items[index],
                selected = false,
                onClick = {
                    onOpen(index)
                },
                onLongClick = {

                }
            )
        }
    }
}