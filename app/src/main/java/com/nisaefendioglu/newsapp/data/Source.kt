package com.nisaefendioglu.newsapp.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName


@Entity(tableName = "source")
data class Source(

    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: String = "",

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String = ""
)