package com.nisaefendioglu.newsapp.data.model
data class NewsResponse(
    val articles: MutableList<NewsArticle>,
    val status: String,
    val totalResults: Int
)