package com.antique.suspend_mvvm.repo

import com.antique.suspend_mvvm.model.DailyResponse

interface Repository {
    suspend fun fetchDaily(): DailyResponse
}