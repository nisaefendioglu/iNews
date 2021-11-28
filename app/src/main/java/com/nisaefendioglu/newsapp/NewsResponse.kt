package com.nisaefendioglu.newsapp


import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles")
    var articles: List<NewsArticle> = listOf(),
    @SerializedName("status")
    var status: String = "",
    @SerializedName("totalResults")
    var totalResults: Int = 0
) {
}