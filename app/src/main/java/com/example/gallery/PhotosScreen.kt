package com.example.gallery

import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
                item = items[index]
            ) {
                onOpen(index)
            }
        }
    }
}