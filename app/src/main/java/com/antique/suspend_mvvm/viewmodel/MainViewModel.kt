package com.antique.suspend_mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antique.suspend_mvvm.model.ApiStatus
import com.antique.suspend_mvvm.model.DailyUiState
import com.antique.suspend_mvvm.usecase.GetDailyUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val getDailyUseCase: GetDailyUseCase) : ViewModel() {
    private val _daily = MutableStateFlow<ApiStatus<List<DailyUiState>>>(ApiStatus.Loading)
    val daily: StateFlow<ApiStatus<List<DailyUiState>>> get() = _daily

    fun load() {
        viewModelScope.launch {
            try {
                val response = getDailyUseCase()
                _daily.value = ApiStatus.Success(response)
            } catch (e: Exception) {
                Log.d("ApiStatusTest", "occur exception: ${e.toString()}")
                _daily.value = ApiStatus.Error(e.message.toString())
            }
        }
    }
}