package com.nisaefendioglu.newsapp.data
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable

class NewsDataSourceFactory(
    private val apiServiceService: ApiService,
    private val compositeDisposable: CompositeDisposable
) : DataSource.Factory<Int, Model>() {

    val newsLiveDataSource = MutableLiveData<ArticleDataSource>()

    override fun create(): DataSource<Int, Model> {
        val newsDataSource =
            ArticleDataSource(
                apiServiceService,
                compositeDisposable
            )
        newsLiveDataSource.postValue(newsDataSource)
        return newsDataSource
    }
}