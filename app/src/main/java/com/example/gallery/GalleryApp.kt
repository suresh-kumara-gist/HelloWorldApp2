package com.example.gallery

import android.Manifest
import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun GalleryApp() {

    val context = LocalContext.current
    val repo = remember { MediaRepository(context) }

    var images by remember { mutableStateOf(listOf<MediaFile>()) }
    var granted by remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted = it }

    LaunchedEffect(Unit) {
        permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    if (granted) {
        LaunchedEffect(Unit) {
            images = repo.loadImages()
        }
    }

    MaterialTheme {

        if (!granted) {
            Text("Permission required")
        } else {

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(4.dp)
            ) {

                items(images) { item ->

                    Image(
                        painter = rememberAsyncImagePainter(item.uri),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(2.dp)
                            .aspectRatio(1f)
                    )
                }
            }
        }
    }
}