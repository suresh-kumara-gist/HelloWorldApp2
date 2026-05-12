package com.example.gallery

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    var favorites by mutableStateOf(setOf<String>())

    var darkMode by mutableStateOf(false)

    var selectedItems by mutableStateOf(setOf<String>())

    var searchQuery by mutableStateOf("")

    fun toggleFavorite(uri: String) {

        favorites =
            if (favorites.contains(uri)) {
                favorites - uri
            } else {
                favorites + uri
            }
    }

    fun toggleSelection(uri: String) {

        selectedItems =
            if (selectedItems.contains(uri)) {
                selectedItems - uri
            } else {
                selectedItems + uri
            }
    }
}