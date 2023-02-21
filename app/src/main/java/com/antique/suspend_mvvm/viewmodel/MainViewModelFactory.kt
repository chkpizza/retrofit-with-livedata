package com.antique.suspend_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.antique.suspend_mvvm.FakeApiService
import com.antique.suspend_mvvm.datasource.RemoteDataSource
import com.antique.suspend_mvvm.repo.RepositoryImpl
import com.antique.suspend_mvvm.usecase.GetDailyUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            val fakeService = Retrofit.Builder()
                .baseUrl("https://mocki.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FakeApiService::class.java)


            return MainViewModel(GetDailyUseCase(RepositoryImpl(RemoteDataSource(fakeService)))) as T
        }
        throw IllegalArgumentException("unknown view model")
    }
}