package com.nisaefendioglu.newsapp.network.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00160\u0015J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/nisaefendioglu/newsapp/network/repository/NewsRepository;", "", "remoteDataSource", "Lcom/nisaefendioglu/newsapp/api/ApiHelper;", "localDataSource", "Lcom/nisaefendioglu/newsapp/data/DAO;", "(Lcom/nisaefendioglu/newsapp/api/ApiHelper;Lcom/nisaefendioglu/newsapp/data/DAO;)V", "deleteNews", "", "news", "Lcom/nisaefendioglu/newsapp/data/model/NewsArticle;", "(Lcom/nisaefendioglu/newsapp/data/model/NewsArticle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNews", "Lcom/nisaefendioglu/newsapp/utils/NetworkResult;", "Lcom/nisaefendioglu/newsapp/data/model/NewsResponse;", "countryCode", "", "pageNumber", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSavedNews", "Landroidx/lifecycle/LiveData;", "", "saveNews", "", "app_devDebug"})
public final class NewsRepository {
    private final com.nisaefendioglu.newsapp.api.ApiHelper remoteDataSource = null;
    private final com.nisaefendioglu.newsapp.data.DAO localDataSource = null;
    
    @javax.inject.Inject()
    public NewsRepository(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.api.ApiHelper remoteDataSource, @org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.data.DAO localDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNews(@org.jetbrains.annotations.NotNull()
    java.lang.String countryCode, int pageNumber, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nisaefendioglu.newsapp.utils.NetworkResult<com.nisaefendioglu.newsapp.data.model.NewsResponse>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveNews(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.data.model.NewsArticle news, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nisaefendioglu.newsapp.data.model.NewsArticle>> getSavedNews() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteNews(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.data.model.NewsArticle news, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}