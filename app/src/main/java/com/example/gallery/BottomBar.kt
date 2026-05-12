package com.example.gallery

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun BottomBar(
    selected: Int,
    onSelected: (Int) -> Unit
) {

    NavigationBar {

        NavigationBarItem(
            selected = selected == 0,
            onClick = { onSelected(0) },
            label = { Text("Photos") },
            icon = {}
        )

        NavigationBarItem(
            selected = selected == 1,
            onClick = { onSelected(1) },
            label = { Text("Videos") },
            icon = {}
        )

        NavigationBarItem(
            selected = selected == 2,
            onClick = { onSelected(2) },
            label = { Text("Docs") },
            icon = {}
        )
    }
}