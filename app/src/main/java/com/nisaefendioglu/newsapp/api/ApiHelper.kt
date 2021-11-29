
package com.nisaefendioglu.newsapp.api

import com.nisaefendioglu.newsapp.data.model.NewsResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getNews(countryCode: String, pageNumber: Int): Response<NewsResponse>
}