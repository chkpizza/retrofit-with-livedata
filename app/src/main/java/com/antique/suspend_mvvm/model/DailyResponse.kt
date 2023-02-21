package com.antique.suspend_mvvm.model

import com.google.gson.annotations.SerializedName

data class DailyResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    @SerializedName("result")
    val daily: List<Daily>
) {
    /*
    fun toUiStateList(): List<DailyUiState> {
        val uiStates = mutableListOf<DailyUiState>()
        for(item in daily) {
            uiStates.add(DailyUiState(item.content, item.created_at, item.diary_id, item.emotion, item.evaluation))
        }
        return uiStates.toList()
    }

     */
    fun convert(): List<DailyUiState> {
        val uiStates = mutableListOf<DailyUiState>()
        for(item in daily) {
            uiStates.add(item.toUiState())
        }
        return uiStates.toList()
    }
}

data class Daily(
    val content: String,
    val created_at: String,
    val diary_id: Int,
    val emotion: String,
    val evaluation: Int,
    val images: List<String>
) {
    fun toUiState(): DailyUiState {
        return DailyUiState(content, created_at, diary_id, emotion, evaluation)
    }
}
