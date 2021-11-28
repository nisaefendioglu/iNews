package com.nisaefendioglu.newsapp.data.model.resourse
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity(tableName = "article")
data class Article(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: String = "",

    @ColumnInfo(name = "author")
    @SerializedName("author")
    var author: String? = null,

    @ColumnInfo(name = "content")
    @SerializedName("content")
    var content: String? = "",

    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String = "",

    @ColumnInfo(name = "publishedAt")
    @SerializedName("publishedAt")
    var publishedAt: String = "",

    @ColumnInfo(name = "source")
    @SerializedName("source")
    var source: Source = Source(),

    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String = "",

    @ColumnInfo(name = "url")
    @SerializedName("url")
    var url: String = "",

    @ColumnInfo(name = "urlToImage")
    @SerializedName("urlToImage")
    var urlToImage: String? = null
) : Serializable {
    fun getAuthorName(): CharSequence? {
        val builder = StringBuilder()
        author?.let { authorName ->
            builder.append(authorName)
        }

        if (builder.isNotEmpty()) {
            builder.append("${(source.let { return@let " - ${it.name}" })}")
        } else {
            builder.append(source.let { it.name })
        }

        return builder.toString()
    }
}