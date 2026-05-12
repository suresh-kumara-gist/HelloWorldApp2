package com.example.gallery

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun GalleryApp() {

    val context = LocalContext.current

    val repo = remember {
        MediaRepository(context)
    }

    var tab by remember { mutableStateOf(0) }

    var granted by remember {
        mutableStateOf(false)
    }

    var images by remember {
        mutableStateOf(listOf<MediaFile>())
    }

    var videos by remember {
        mutableStateOf(listOf<MediaFile>())
    }

    var docs by remember {
        mutableStateOf(listOf<MediaFile>())
    }

    val launcher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            granted = it
        }

    LaunchedEffect(Unit) {
        launcher.launch(
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }

    if (granted) {

        LaunchedEffect(Unit) {

            images = repo.loadImages()
            videos = repo.loadVideos()
            docs = repo.loadDocuments()
        }
    }

    Scaffold(

        bottomBar = {

            BottomBar(
                selected = tab,
                onSelected = {
                    tab = it
                }
            )
        }

    ) { padding ->

        if (!granted) {

            Text("Storage permission required")

        } else {

            when (tab) {

                0 -> PhotosScreen(
                    items = images,
                    onOpen = {}
                )

                1 -> VideosScreen(
                    items = videos
                )

                2 -> DocumentsScreen(
                    items = docs
                )
            }
        }
    }
}