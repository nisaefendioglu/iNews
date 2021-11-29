
package com.nisaefendioglu.newsapp.network.repository

import com.nisaefendioglu.newsapp.data.DAO
import com.nisaefendioglu.newsapp.data.model.NewsArticle
import com.nisaefendioglu.newsapp.data.model.NewsResponse
import com.nisaefendioglu.newsapp.api.ApiHelper
import com.nisaefendioglu.newsapp.utils.NetworkResult
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val remoteDataSource: ApiHelper,
    private val localDataSource: DAO
) {

    suspend fun getNews(countryCode: String, pageNumber: Int): NetworkResult<NewsResponse> {
        return try {
            val response = remoteDataSource.getNews(countryCode, pageNumber)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                NetworkResult.Success(result)
            } else {
                NetworkResult.Error("Error")
            }
        } catch (e: Exception) {
            NetworkResult.Error("Error ${e.localizedMessage}")
        }
    }

    //local üzerinde kaydet,sil işlemleri burada.
    suspend fun saveNews(news: NewsArticle) = localDataSource.upsert(news)
    fun getSavedNews() = localDataSource.getAllNews()
    suspend fun deleteNews(news: NewsArticle) = localDataSource.deleteNews(news)
}