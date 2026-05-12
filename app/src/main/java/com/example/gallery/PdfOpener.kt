package com.example.gallery

import android.content.Context
import android.content.Intent
import android.net.Uri

fun openPdf(
    context: Context,
    uri: Uri
) {

    val intent = Intent(Intent.ACTION_VIEW)

    intent.setDataAndType(
        uri,
        "application/pdf"
    )

    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

    context.startActivity(intent)
}