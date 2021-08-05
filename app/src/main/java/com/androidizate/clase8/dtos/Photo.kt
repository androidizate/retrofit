package com.androidizate.clase8.dtos

data class Photo(
    val albumId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val url: String = "",
    val thumbnailUrl: String = ""
)