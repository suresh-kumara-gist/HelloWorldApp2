package com.example.gallery

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AlbumsScreen(
    items: List<MediaFile>
) {

    val grouped =
        items.groupBy {

            it.name.substringBeforeLast("/")
        }

    LazyColumn {

        grouped.forEach { (folder, files) ->

            item {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {}
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(folder)

                        Text("${files.size} items")
                    }
                }
            }
        }
    }
}