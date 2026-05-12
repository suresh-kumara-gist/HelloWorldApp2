package com.example.gallery

import android.content.ContentUris
import android.content.Context
import android.provider.MediaStore

class MediaRepository(private val context: Context) {

    fun loadImages(): List<MediaFile> {

        val list = mutableListOf<MediaFile>()

        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        val cursor = context.contentResolver.query(
            uri,
            null,
            null,
            null,
            "${MediaStore.Images.Media.DATE_ADDED} DESC"
        )

        cursor?.use {

            val idIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            val nameIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
            val dateIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_ADDED)

            while (it.moveToNext()) {

                val id = it.getLong(idIndex)

                list.add(
                    MediaFile(
                        uri = ContentUris.withAppendedId(uri, id).toString(),
                        name = it.getString(nameIndex),
                        type = "image",
                        date = it.getLong(dateIndex)
                    )
                )
            }
        }

        return list
    }

    fun loadVideos(): List<MediaFile> {

        val list = mutableListOf<MediaFile>()

        val uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI

        val cursor = context.contentResolver.query(
            uri,
            null,
            null,
            null,
            "${MediaStore.Video.Media.DATE_ADDED} DESC"
        )

        cursor?.use {

            val idIndex = it.getColumnIndexOrThrow(MediaStore.Video.Media._ID)
            val nameIndex = it.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME)
            val dateIndex = it.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_ADDED)

            while (it.moveToNext()) {

                val id = it.getLong(idIndex)

                list.add(
                    MediaFile(
                        uri = ContentUris.withAppendedId(uri, id).toString(),
                        name = it.getString(nameIndex),
                        type = "video",
                        date = it.getLong(dateIndex)
                    )
                )
            }
        }

        return list
    }

    fun loadDocuments(): List<MediaFile> {

        val list = mutableListOf<MediaFile>()

        val uri = MediaStore.Files.getContentUri("external")

        val selection =
            "${MediaStore.Files.FileColumns.MIME_TYPE} LIKE ?"

        val args = arrayOf("%application%")

        val cursor = context.contentResolver.query(
            uri,
            null,
            selection,
            args,
            "${MediaStore.Files.FileColumns.DATE_ADDED} DESC"
        )

        cursor?.use {

            val idIndex =
                it.getColumnIndexOrThrow(MediaStore.Files.FileColumns._ID)

            val nameIndex =
                it.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DISPLAY_NAME)

            val dateIndex =
                it.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATE_ADDED)

            while (it.moveToNext()) {

                val id = it.getLong(idIndex)

                list.add(
                    MediaFile(
                        uri = ContentUris.withAppendedId(uri, id).toString(),
                        name = it.getString(nameIndex),
                        type = "document",
                        date = it.getLong(dateIndex)
                    )
                )
            }
        }

        return list
    }
}