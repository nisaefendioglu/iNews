package com.nisaefendioglu.newsapp.data.remote
import com.nisaefendioglu.newsapp.data.model.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    fun fetchNews(@Query("page") page: Int): Single<NewsResponse>
}