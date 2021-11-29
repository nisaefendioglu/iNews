package com.nisaefendioglu.newsapp.data;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/nisaefendioglu/newsapp/data/DAO;", "", "deleteAllNews", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNews", "newsArticle", "Lcom/nisaefendioglu/newsapp/data/model/NewsArticle;", "(Lcom/nisaefendioglu/newsapp/data/model/NewsArticle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNews", "Landroidx/lifecycle/LiveData;", "", "upsert", "", "app_devDebug"})
public abstract interface DAO {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.data.model.NewsArticle newsArticle, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM news")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.nisaefendioglu.newsapp.data.model.NewsArticle>> getAllNews();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteNews(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.data.model.NewsArticle newsArticle, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "Delete FROM news")
    public abstract java.lang.Object deleteAllNews(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}