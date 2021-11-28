package com.nisaefendioglu.newsapp.viewmodel
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nisaefendioglu.newsapp.data.ArticlePagedListRepository

class NewsViewModelFactory(
    private val application: Application,
    private val newsRepository: ArticlePagedListRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            Application::class.java,
            ArticlePagedListRepository::class.java
        ).newInstance(application, newsRepository)
    }
}