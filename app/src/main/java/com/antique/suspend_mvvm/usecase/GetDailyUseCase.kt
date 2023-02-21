package com.antique.suspend_mvvm.usecase

import com.antique.suspend_mvvm.repo.Repository

class GetDailyUseCase(private val repository: Repository) {
    suspend operator fun invoke() = repository.fetchDaily().convert()
}