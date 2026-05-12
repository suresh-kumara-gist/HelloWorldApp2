package com.example.gallery

import android.os.Environment
import androidx.compose.material3.*
import androidx.compose.runtime.*
import java.io.File

@Composable
fun StorageAnalyzerScreen() {

    val root = Environment.getExternalStorageDirectory()

    val total =
        root.totalSpace / (1024 * 1024 * 1024)

    val free =
        root.freeSpace / (1024 * 1024 * 1024)

    Column {

        Text("Storage Analyzer")

        Text("Total: ${total} GB")

        Text("Free: ${free} GB")
    }
}