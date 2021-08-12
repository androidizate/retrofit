package com.androidizate.clase8.domain.entities

data class User(
    val id: Long,
    val name: String,
    val lastname: String,
    val email: String,
    val isBlocked: Boolean = false
)
