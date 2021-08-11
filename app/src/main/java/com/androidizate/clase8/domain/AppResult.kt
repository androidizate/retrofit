package com.androidizate.clase8.domain

sealed class AppResult<T> {
    data class Success<T>(val result: T) : AppResult<T>()
    data class Error<T>(val message: String) : AppResult<T>()
}
