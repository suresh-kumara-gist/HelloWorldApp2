package com.example.gallery

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.pager.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipeViewer(
    items: List<MediaFile>,
    startIndex: Int
) {

    val pagerState =
        rememberPagerState(
            initialPage = startIndex,
            pageCount = { items.size }
        )

    HorizontalPager(
        state = pagerState
    ) { page ->

        Image(
            painter = rememberAsyncImagePainter(
                items[page].uri
            ),
            contentDescription = null,
            modifier = Modifier
        )
    }
}