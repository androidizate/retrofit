package com.androidizate.clase8.data.datasources.remote.dtos

data class Todo(
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val completed: Boolean = false
)
