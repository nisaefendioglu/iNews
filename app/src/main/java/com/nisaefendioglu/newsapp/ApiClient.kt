package com.nisaefendioglu.newsapp

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiClient {

    @GET("top-headlines")
    fun fetchNews(@Query("page") page: Int): Single<NewsResponse>
}