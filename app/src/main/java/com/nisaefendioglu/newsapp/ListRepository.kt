package com.nisaefendioglu.newsapp

import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.reactivex.disposables.CompositeDisposable


class ListRepository(private val apiServiceClient: ApiClient) {

    lateinit var newsPagedList: LiveData<PagedList<NewsArticle>>
    lateinit var articleDataSourceFactory: NewsArticleDataSource

    fun fetchLiveSearchArticlePagedList(
        compositeDisposable: CompositeDisposable
    ): LiveData<PagedList<NewsArticle>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(ITEM_PER_PAGE)
            .build()

        articleDataSourceFactory = NewsArticleDataSource(
            apiServiceClient,
            compositeDisposable
        )

        newsPagedList = LivePagedListBuilder(articleDataSourceFactory, config).build()
        return newsPagedList
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap(newsPagedList, Function {
            articleDataSourceFactory.newsLiveDataSource.value?.networkState
        })
    }
}