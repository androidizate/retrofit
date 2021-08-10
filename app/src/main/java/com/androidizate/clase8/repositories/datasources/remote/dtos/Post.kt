package com.androidizate.clase8.repositories.datasources.remote.dtos

data class Post(
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val body: String = ""
)