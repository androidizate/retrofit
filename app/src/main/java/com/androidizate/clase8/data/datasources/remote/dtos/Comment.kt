package com.androidizate.clase8.data.datasources.remote.dtos

data class Comment(
    val postId: Int = 0,
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val body: String = ""
)