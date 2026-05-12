package com.example.gallery

import android.content.ContentUris
import android.content.Context
import android.provider.MediaStore

class MediaRepository(private val context: Context) {

    fun loadImages(): List<MediaFile> {

        val list = mutableListOf<MediaFile>()

        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        val cursor = context.contentResolver.query(uri, null, null, null, null)

        cursor?.use {

            val idIndex = it.getColumnIndex(MediaStore.Images.Media._ID)
            val nameIndex = it.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)
            val dateIndex = it.getColumnIndex(MediaStore.Images.Media.DATE_ADDED)

            while (it.moveToNext()) {

                val id = it.getLong(idIndex)
                val name = it.getString(nameIndex)
                val date = it.getLong(dateIndex)

                val contentUri = ContentUris.withAppendedId(uri, id)

                list.add(
                    MediaFile(
                        uri = contentUri.toString(),
                        name = name,
                        type = "image",
                        date = date
                    )
                )
            }
        }

        return list
    }
}