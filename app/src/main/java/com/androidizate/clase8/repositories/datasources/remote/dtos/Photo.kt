package com.androidizate.clase8.repositories.datasources.remote.dtos

data class Photo(
    val albumId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val url: String = "",
    val thumbnailUrl: String = ""
)