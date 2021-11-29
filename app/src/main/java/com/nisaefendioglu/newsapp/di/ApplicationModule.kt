package com.nisaefendioglu.newsapp.di

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import com.nisaefendioglu.newsapp.BuildConfig
import com.nisaefendioglu.newsapp.data.DAO
import com.nisaefendioglu.newsapp.data.LocalDatabase
import com.nisaefendioglu.newsapp.api.ApiHelper
import com.nisaefendioglu.newsapp.api.ApiHelperImpl
import com.nisaefendioglu.newsapp.api.NewsApi
import com.nisaefendioglu.newsapp.network.repository.NewsRepository
import com.nisaefendioglu.newsapp.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    private val TAG = "NewsApp"

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            Log.d(TAG, message)
        }
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        LocalDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideNewsDao(db: LocalDatabase) = db.getNewsDao()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: ApiHelper,
        localDataSource: DAO
    ) = NewsRepository(remoteDataSource, localDataSource)
}