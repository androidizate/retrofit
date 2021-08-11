package com.androidizate.clase8.presentation.main

import com.androidizate.clase8.repositories.datasources.remote.dtos.User

sealed class MainUIState {
    object LoadingState : MainUIState()
    data class SuccessState(val users: List<User>) : MainUIState()
    data class ErrorState(val message: String) : MainUIState()
}
