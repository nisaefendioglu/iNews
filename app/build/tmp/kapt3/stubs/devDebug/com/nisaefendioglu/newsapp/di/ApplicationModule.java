package com.nisaefendioglu.newsapp.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0012H\u0007J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/nisaefendioglu/newsapp/di/ApplicationModule;", "", "()V", "TAG", "", "provideApiHelper", "Lcom/nisaefendioglu/newsapp/api/ApiHelper;", "apiHelper", "Lcom/nisaefendioglu/newsapp/api/ApiHelperImpl;", "provideDatabase", "Lcom/nisaefendioglu/newsapp/data/LocalDatabase;", "appContext", "Landroid/content/Context;", "provideNewsApi", "Lcom/nisaefendioglu/newsapp/api/NewsApi;", "retrofit", "Lretrofit2/Retrofit;", "provideNewsDao", "Lcom/nisaefendioglu/newsapp/data/DAO;", "db", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "provideRepository", "Lcom/nisaefendioglu/newsapp/network/repository/NewsRepository;", "remoteDataSource", "localDataSource", "provideRetrofit", "okHttpClient", "app_devDebug"})
@dagger.Module()
public final class ApplicationModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.nisaefendioglu.newsapp.di.ApplicationModule INSTANCE = null;
    private static final java.lang.String TAG = "NewsApp";
    
    private ApplicationModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final okhttp3.OkHttpClient provideOkHttpClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.nisaefendioglu.newsapp.api.NewsApi provideNewsApi(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.nisaefendioglu.newsapp.api.ApiHelper provideApiHelper(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.api.ApiHelperImpl apiHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.nisaefendioglu.newsapp.data.LocalDatabase provideDatabase(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context appContext) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.nisaefendioglu.newsapp.data.DAO provideNewsDao(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.data.LocalDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.nisaefendioglu.newsapp.network.repository.NewsRepository provideRepository(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.api.ApiHelper remoteDataSource, @org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.data.DAO localDataSource) {
        return null;
    }
}