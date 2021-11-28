
package com.nisaefendioglu.newsapp.data.model
import com.google.gson.annotations.SerializedName
import com.nisaefendioglu.newsapp.data.model.resourse.Article

data class NewsResponse(
    @SerializedName("articles")
    var articles: List<Article> = listOf(),
    @SerializedName("status")
    var status: String = "",
    @SerializedName("totalResults")
    var totalResults: Int = 0
) {
}