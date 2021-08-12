package com.androidizate.clase8.presentation.main

import com.androidizate.clase8.presentation.adapters.UIUser

sealed class MainUIState {
    object LoadingState : MainUIState()
    data class SuccessState(val userResponses: List<UIUser>) : MainUIState()
    data class ErrorState(val message: String) : MainUIState()
}
