
package com.nisaefendioglu.newsapp.api

import com.nisaefendioglu.newsapp.data.model.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val newsApi: NewsApi) : ApiHelper {

    override suspend fun getNews(countryCode: String, pageNumber: Int): Response<NewsResponse> =
        newsApi.getNews(countryCode, pageNumber)
    //bilgileri al işle
}