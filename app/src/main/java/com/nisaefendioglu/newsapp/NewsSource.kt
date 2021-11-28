package com.nisaefendioglu.newsapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "source")
data class NewsSource(

    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: String = "",

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String = ""
)