package com.nisaefendioglu.newsapp.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nisaefendioglu.newsapp.data.model.NewsArticle
//cihazda tutmak için.
@Database(
    entities = [NewsArticle::class],
    version = 1 ,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun getNewsDao(): DAO

    companion object {
        @Volatile
        private var instance: LocalDatabase? = null

        fun getDatabase(context: Context): LocalDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        //cihazdaki local database --> news_database
        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, LocalDatabase::class.java, "news_database")
                .fallbackToDestructiveMigration()
                .build()
    }
}