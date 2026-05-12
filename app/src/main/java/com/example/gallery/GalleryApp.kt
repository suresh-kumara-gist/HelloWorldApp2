package com.example.gallery

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun GalleryApp() {

    val context = LocalContext.current

    val repo = remember {
        MediaRepository(context)
    }

    val viewModel = remember {
        GalleryViewModel()
    }

    var tab by remember {
        mutableStateOf(0)
    }

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

    val permission =
        if (Build.VERSION.SDK_INT >= 33) {
            Manifest.permission.READ_MEDIA_IMAGES
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }

    val launcher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            granted = it
        }

    LaunchedEffect(Unit) {
        launcher.launch(permission)
    }

    if (granted) {

        LaunchedEffect(Unit) {

            images = repo.loadImages()
            videos = repo.loadVideos()
            docs = repo.loadDocuments()
        }
    }

    val filteredImages =
        images.filter {

            it.name.contains(
                viewModel.searchQuery,
                ignoreCase = true
            )
        }

    val filteredVideos =
        videos.filter {

            it.name.contains(
                viewModel.searchQuery,
                ignoreCase = true
            )
        }

    val filteredDocs =
        docs.filter {

            it.name.contains(
                viewModel.searchQuery,
                ignoreCase = true
            )
        }

    Scaffold(

        topBar = {

            Column {

                Text(
                    text = "Gallery App",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(12.dp)
                )

                GallerySearchBar(
                    query = viewModel.searchQuery,
                    onQueryChange = {
                        viewModel.searchQuery = it
                    }
                )
            }
        },

        bottomBar = {

            BottomBar(
                selected = tab,
                onSelected = {
                    tab = it
                }
            )
        }

    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            if (!granted) {

                Text(
                    text = "Storage permission required",
                    modifier = Modifier.padding(16.dp)
                )

            } else {

                when (tab) {

                    0 -> PhotosScreen(
                        items = filteredImages,
                        onOpen = {}
                    )

                    1 -> VideosScreen(
                        items = filteredVideos
                    )

                    2 -> DocumentsScreen(
                        items = filteredDocs
                    )
                }
            }
        }
    }
}