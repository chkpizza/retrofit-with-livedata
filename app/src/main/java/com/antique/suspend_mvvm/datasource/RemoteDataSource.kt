package com.antique.suspend_mvvm.datasource

import com.antique.suspend_mvvm.FakeApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteDataSource(private val fakeApiService: FakeApiService) {
    suspend fun fetchDaily() = withContext(Dispatchers.IO) {
        fakeApiService.fetchDaily()
    }
}
