package com.example.gallery

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DocumentsScreen(
    items: List<MediaFile>
) {

    LazyColumn {

        items(items) { item ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {}
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(item.name)
                    Text(item.type)
                }
            }
        }
    }
}