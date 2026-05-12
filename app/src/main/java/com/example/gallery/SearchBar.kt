package com.example.gallery

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun GallerySearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {

    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        label = {
            Text("Search")
        }
    )
}