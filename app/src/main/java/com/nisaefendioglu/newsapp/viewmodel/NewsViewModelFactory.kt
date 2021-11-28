package com.nisaefendioglu.newsapp.viewmodel
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nisaefendioglu.newsapp.data.NewsListRepository

class NewsViewModelFactory(
    private val application: Application,
    private val newsRepository: NewsListRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            Application::class.java,
            NewsListRepository::class.java
        ).newInstance(application, newsRepository)
    }
}