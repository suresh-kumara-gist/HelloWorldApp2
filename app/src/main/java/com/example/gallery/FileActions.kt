package com.example.gallery

import android.content.Context
import android.content.Intent
import android.net.Uri

fun shareFile(
    context: Context,
    uri: Uri
) {

    val intent = Intent(Intent.ACTION_SEND)

    intent.type = "*/*"
    intent.putExtra(Intent.EXTRA_STREAM, uri)

    context.startActivity(
        Intent.createChooser(intent, "Share")
    )
}

fun deleteFile(
    context: Context,
    uri: Uri
) {

    context.contentResolver.delete(
        uri,
        null,
        null
    )
}