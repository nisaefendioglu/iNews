package com.nisaefendioglu.newsapp.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.nisaefendioglu.newsapp.data.Model
import com.nisaefendioglu.newsapp.data.NewsListRepository
import com.nisaefendioglu.newsapp.util.NetworkState
import io.reactivex.disposables.CompositeDisposable

class NewsViewModel(
    application: Application,
    newsRepository: NewsListRepository
) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    private val searchTag = MutableLiveData<String>()

    val newsPagedList: LiveData<PagedList<Model>> by lazy {
        newsRepository.fetchLiveSearchArticlePagedList(compositeDisposable)
    }

    val networkState: LiveData<NetworkState>? by lazy {
        newsRepository.getNetworkState()
    }

    fun isSearchListEmpty(): Boolean {
        return newsPagedList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}