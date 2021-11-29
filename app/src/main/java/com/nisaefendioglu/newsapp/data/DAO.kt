
package com.nisaefendioglu.newsapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nisaefendioglu.newsapp.data.model.NewsArticle
@Dao
interface DAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(newsArticle: NewsArticle): Long

    @Query("SELECT * FROM news")
    fun getAllNews(): LiveData<List<NewsArticle>>

    @Delete
    suspend fun deleteNews(newsArticle: NewsArticle)

    @Query("Delete FROM news")
    suspend fun deleteAllNews()
}