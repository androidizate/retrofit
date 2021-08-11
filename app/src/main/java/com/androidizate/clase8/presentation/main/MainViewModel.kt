package com.androidizate.clase8.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidizate.clase8.domain.AppResult.Error
import com.androidizate.clase8.domain.AppResult.Success
import com.androidizate.clase8.domain.GetAllUsers
import com.androidizate.clase8.presentation.main.MainUIState.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllUsers: GetAllUsers
) : ViewModel() {

    private var mutableUiState: MutableLiveData<MainUIState> = MutableLiveData()
    val uiState: LiveData<MainUIState> = mutableUiState

    fun onCreate() = viewModelScope.launch {
        mutableUiState.value = LoadingState
        when (val result = getAllUsers()) {
            is Error -> mutableUiState.value = ErrorState(result.message)
            is Success -> mutableUiState.value = SuccessState(result.result)
        }
    }
}
