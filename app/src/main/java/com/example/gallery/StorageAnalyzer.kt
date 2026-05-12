package com.example.gallery

import android.os.Environment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StorageAnalyzerScreen() {

    val root = Environment.getExternalStorageDirectory()

    val total =
        root.totalSpace / (1024 * 1024 * 1024)

    val free =
        root.freeSpace / (1024 * 1024 * 1024)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text("Storage Analyzer")

        Text("Total Storage: ${total} GB")

        Text("Free Storage: ${free} GB")
    }
}