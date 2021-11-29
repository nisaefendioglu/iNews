package com.nisaefendioglu.newsapp.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0006\u0010\u001c\u001a\u00020\u0014R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/nisaefendioglu/newsapp/utils/EndlessRecyclerOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "threshHold", "", "(I)V", "firstVisibleItem", "isError", "", "()Z", "setError", "(Z)V", "isLastPage", "setLastPage", "isLoading", "setLoading", "isScrolling", "setScrolling", "totalItemCount", "visibleItemCount", "onLoadMore", "", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "resetOnLoadMore", "app_devDebug"})
public abstract class EndlessRecyclerOnScrollListener extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    private final int threshHold = 0;
    private boolean isError = false;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private boolean isScrolling = false;
    private int firstVisibleItem = 0;
    private int visibleItemCount = 0;
    private int totalItemCount = 0;
    
    public EndlessRecyclerOnScrollListener() {
        super();
    }
    
    public EndlessRecyclerOnScrollListener(int threshHold) {
        super();
    }
    
    public final boolean isError() {
        return false;
    }
    
    public final void setError(boolean p0) {
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final void setLoading(boolean p0) {
    }
    
    public final boolean isLastPage() {
        return false;
    }
    
    public final void setLastPage(boolean p0) {
    }
    
    public final boolean isScrolling() {
        return false;
    }
    
    public final void setScrolling(boolean p0) {
    }
    
    @java.lang.Override()
    public void onScrollStateChanged(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, int newState) {
    }
    
    @java.lang.Override()
    public void onScrolled(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, int dx, int dy) {
    }
    
    public final void resetOnLoadMore() {
    }
    
    public abstract void onLoadMore();
}