package com.nisaefendioglu.newsapp.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/nisaefendioglu/newsapp/api/ApiHelperImpl;", "Lcom/nisaefendioglu/newsapp/api/ApiHelper;", "newsApi", "Lcom/nisaefendioglu/newsapp/api/NewsApi;", "(Lcom/nisaefendioglu/newsapp/api/NewsApi;)V", "getNews", "Lretrofit2/Response;", "Lcom/nisaefendioglu/newsapp/data/model/NewsResponse;", "countryCode", "", "pageNumber", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_devDebug"})
public final class ApiHelperImpl implements com.nisaefendioglu.newsapp.api.ApiHelper {
    private final com.nisaefendioglu.newsapp.api.NewsApi newsApi = null;
    
    @javax.inject.Inject()
    public ApiHelperImpl(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.api.NewsApi newsApi) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getNews(@org.jetbrains.annotations.NotNull()
    java.lang.String countryCode, int pageNumber, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.nisaefendioglu.newsapp.data.model.NewsResponse>> continuation) {
        return null;
    }
}