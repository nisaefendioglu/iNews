package com.nisaefendioglu.newsapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

const val DEFAULT_SEARCH_TAG = "android"

class ArticleDataSource(
    private val apiServiceService: ApiClient,
    private val compositeDisposable: CompositeDisposable
) : PageKeyedDataSource<Int, NewsArticle>() {

    private var page = FIRST_PAGE
    private var TAG = ArticleDataSource::class.java.simpleName

    val networkState: MutableLiveData<NetworkState> = MutableLiveData()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, NewsArticle>
    ) {

        networkState.postValue(NetworkState.LOADING)

        compositeDisposable.add(fetchNews(page, callback))
    }

    private fun fetchNews(
        page: Int,
        callback: LoadInitialCallback<Int, NewsArticle>
    ): Disposable {
        return apiServiceService.fetchNews(page)
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    callback.onResult(it.articles, null, page + 1)
                    networkState.postValue(NetworkState.LOADED)
                },
                {
                    networkState.postValue(NetworkState.ERROR)
                    Log.e(TAG, it.message)
                }
            )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, NewsArticle>) {
        networkState.postValue(NetworkState.LOADING)
        compositeDisposable.add(fetchMoreNews(params.key, callback))
    }

    private fun fetchMoreNews(
        page: Int,
        callback: LoadCallback<Int, NewsArticle>
    ): Disposable {
        return apiServiceService.fetchNews(page)
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    if ((it.totalResults / ITEM_PER_PAGE) >= page) {
                        callback.onResult(it.articles, page + 1)
                        networkState.postValue(NetworkState.LOADED)
                    } else {
                        networkState.postValue(NetworkState.ENDOFLIST)
                    }
                },
                {
                    networkState.postValue(NetworkState.ERROR)
                    Log.e(TAG, it.message)
                }
            )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, NewsArticle>) {

    }
}