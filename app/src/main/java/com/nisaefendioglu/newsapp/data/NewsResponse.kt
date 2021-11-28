
package com.nisaefendioglu.newsapp.data
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles")
    var models: List<Model> = listOf(),
    @SerializedName("status")
    var status: String = "",
    @SerializedName("totalResults")
    var totalResults: Int = 0
) {
}