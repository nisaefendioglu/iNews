package com.nisaefendioglu.newsapp

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import com.nisaefendioglu.newsapp.NewsArticle
import com.nisaefendioglu.newsapp.ApiClient

class NewsArticleDataSource(
    private val apiServiceService: ApiClient,
    private val compositeDisposable: CompositeDisposable
) : DataSource.Factory<Int, NewsArticle>() {

    val newsLiveDataSource = MutableLiveData<ArticleDataSource>()

    override fun create(): DataSource<Int , NewsArticle> {
        val newsDataSource =
            ArticleDataSource(
                apiServiceService,
                compositeDisposable
            )
        newsLiveDataSource.postValue(newsDataSource)
        return newsDataSource
    }
}
