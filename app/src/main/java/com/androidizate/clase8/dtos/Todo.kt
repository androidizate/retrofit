package com.androidizate.clase8.dtos

data class Todo(
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val completed: Boolean = false
)