package com.nisaefendioglu.newsapp.ui.main;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0011J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\nJ\u000e\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nJ\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060<0\u0013J\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0006\u0010?\u001a\u000204J\u0010\u0010@\u001a\u0002042\u0006\u0010A\u001a\u00020BH\u0002J\u000e\u0010C\u001a\u0002042\u0006\u00105\u001a\u000206R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00138F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u0015R\u000e\u0010%\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0019\"\u0004\b(\u0010\u001bR\u001c\u0010)\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001b\u00a8\u0006D"}, d2 = {"Lcom/nisaefendioglu/newsapp/ui/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/nisaefendioglu/newsapp/network/repository/NewsRepository;", "networkHelper", "Lcom/nisaefendioglu/newsapp/utils/NetworkHelper;", "coroutinesDispatcherProvider", "Lcom/nisaefendioglu/newsapp/di/CoroutinesDispatcherProvider;", "(Lcom/nisaefendioglu/newsapp/network/repository/NewsRepository;Lcom/nisaefendioglu/newsapp/utils/NetworkHelper;Lcom/nisaefendioglu/newsapp/di/CoroutinesDispatcherProvider;)V", "TAG", "", "_errorToast", "Landroidx/lifecycle/MutableLiveData;", "_isSearchActivated", "", "_newsResponse", "Lcom/nisaefendioglu/newsapp/utils/NetworkResult;", "Lcom/nisaefendioglu/newsapp/data/model/NewsResponse;", "errorToast", "Landroidx/lifecycle/LiveData;", "getErrorToast", "()Landroidx/lifecycle/LiveData;", "feedNewsPage", "", "getFeedNewsPage", "()I", "setFeedNewsPage", "(I)V", "feedResponse", "isSearchActivated", "newQuery", "getNewQuery", "()Ljava/lang/String;", "setNewQuery", "(Ljava/lang/String;)V", "newsResponse", "getNewsResponse", "oldQuery", "searchNewsPage", "getSearchNewsPage", "setSearchNewsPage", "searchResponse", "getSearchResponse", "()Lcom/nisaefendioglu/newsapp/data/model/NewsResponse;", "setSearchResponse", "(Lcom/nisaefendioglu/newsapp/data/model/NewsResponse;)V", "totalPage", "getTotalPage", "setTotalPage", "convertPublishedDate", "currentResponse", "deleteNews", "", "news", "Lcom/nisaefendioglu/newsapp/data/model/NewsArticle;", "fetchNews", "countryCode", "formatDate", "strCurrentDate", "getFavoriteNews", "", "handleFeedNewsResponse", "response", "hideErrorToast", "onError", "throwable", "", "saveNews", "app_devDebug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final com.nisaefendioglu.newsapp.network.repository.NewsRepository repository = null;
    private final com.nisaefendioglu.newsapp.utils.NetworkHelper networkHelper = null;
    private final com.nisaefendioglu.newsapp.di.CoroutinesDispatcherProvider coroutinesDispatcherProvider = null;
    private final java.lang.String TAG = "MainViewModel";
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorToast = null;
    private final androidx.lifecycle.MutableLiveData<com.nisaefendioglu.newsapp.utils.NetworkResult<com.nisaefendioglu.newsapp.data.model.NewsResponse>> _newsResponse = null;
    private com.nisaefendioglu.newsapp.data.model.NewsResponse feedResponse;
    private int feedNewsPage = 1;
    private int searchNewsPage = 1;
    @org.jetbrains.annotations.Nullable()
    private com.nisaefendioglu.newsapp.data.model.NewsResponse searchResponse;
    private java.lang.String oldQuery = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String newQuery = "";
    private int totalPage = 1;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isSearchActivated = null;
    
    @javax.inject.Inject()
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.network.repository.NewsRepository repository, @org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.utils.NetworkHelper networkHelper, @org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.di.CoroutinesDispatcherProvider coroutinesDispatcherProvider) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorToast() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.nisaefendioglu.newsapp.utils.NetworkResult<com.nisaefendioglu.newsapp.data.model.NewsResponse>> getNewsResponse() {
        return null;
    }
    
    public final int getFeedNewsPage() {
        return 0;
    }
    
    public final void setFeedNewsPage(int p0) {
    }
    
    public final int getSearchNewsPage() {
        return 0;
    }
    
    public final void setSearchNewsPage(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.nisaefendioglu.newsapp.data.model.NewsResponse getSearchResponse() {
        return null;
    }
    
    public final void setSearchResponse(@org.jetbrains.annotations.Nullable()
    com.nisaefendioglu.newsapp.data.model.NewsResponse p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNewQuery() {
        return null;
    }
    
    public final void setNewQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getTotalPage() {
        return 0;
    }
    
    public final void setTotalPage(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isSearchActivated() {
        return null;
    }
    
    public final void fetchNews(@org.jetbrains.annotations.NotNull()
    java.lang.String countryCode) {
    }
    
    private final com.nisaefendioglu.newsapp.utils.NetworkResult<com.nisaefendioglu.newsapp.data.model.NewsResponse> handleFeedNewsResponse(com.nisaefendioglu.newsapp.utils.NetworkResult<com.nisaefendioglu.newsapp.data.model.NewsResponse> response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nisaefendioglu.newsapp.data.model.NewsResponse convertPublishedDate(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.data.model.NewsResponse currentResponse) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatDate(@org.jetbrains.annotations.NotNull()
    java.lang.String strCurrentDate) {
        return null;
    }
    
    public final void hideErrorToast() {
    }
    
    public final void saveNews(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.data.model.NewsArticle news) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nisaefendioglu.newsapp.data.model.NewsArticle>> getFavoriteNews() {
        return null;
    }
    
    public final void deleteNews(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.data.model.NewsArticle news) {
    }
    
    private final void onError(java.lang.Throwable throwable) {
    }
}