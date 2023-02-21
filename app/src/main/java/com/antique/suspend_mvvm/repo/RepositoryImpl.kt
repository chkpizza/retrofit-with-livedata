package com.antique.suspend_mvvm.repo

import com.antique.suspend_mvvm.datasource.RemoteDataSource
import com.antique.suspend_mvvm.model.DailyResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository {
    override suspend fun fetchDaily(): DailyResponse {
        /*
        val result: DailyResponse

        withContext(Dispatchers.IO) {
            val response = remoteDataSource.fetchDaily()
            if(response.isSuccessful) {
                result = response.body()!!
            } else {
                throw RuntimeException("occur network error")
            }
        }

        return result

         */

        val response = remoteDataSource.fetchDaily()
        if(response.isSuccessful) {
            return response.body()!!
        } else {
            throw RuntimeException("occur response error")
        }
    }
}