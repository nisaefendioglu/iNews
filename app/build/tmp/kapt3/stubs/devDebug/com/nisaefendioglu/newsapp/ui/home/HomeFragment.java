package com.nisaefendioglu.newsapp.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0017H\u0002J\u0010\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/nisaefendioglu/newsapp/ui/home/HomeFragment;", "Lcom/nisaefendioglu/newsapp/base/BaseFragment;", "Lcom/nisaefendioglu/newsapp/databinding/FragmentFeedBinding;", "()V", "countryCode", "", "getCountryCode", "()Ljava/lang/String;", "mainViewModel", "Lcom/nisaefendioglu/newsapp/ui/main/MainViewModel;", "getMainViewModel", "()Lcom/nisaefendioglu/newsapp/ui/main/MainViewModel;", "setMainViewModel", "(Lcom/nisaefendioglu/newsapp/ui/main/MainViewModel;)V", "newsAdapter", "Lcom/nisaefendioglu/newsapp/ui/adapter/NewsAdapter;", "getNewsAdapter", "()Lcom/nisaefendioglu/newsapp/ui/adapter/NewsAdapter;", "setNewsAdapter", "(Lcom/nisaefendioglu/newsapp/ui/adapter/NewsAdapter;)V", "onScrollListener", "Lcom/nisaefendioglu/newsapp/utils/EndlessRecyclerOnScrollListener;", "hideErrorMessage", "", "hideProgressBar", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setBinding", "setupObservers", "setupRecyclerView", "setupUI", "showErrorMessage", "message", "showProgressBar", "app_devDebug"})
public final class HomeFragment extends com.nisaefendioglu.newsapp.base.BaseFragment<com.nisaefendioglu.newsapp.databinding.FragmentFeedBinding> {
    private com.nisaefendioglu.newsapp.utils.EndlessRecyclerOnScrollListener onScrollListener;
    public com.nisaefendioglu.newsapp.ui.main.MainViewModel mainViewModel;
    public com.nisaefendioglu.newsapp.ui.adapter.NewsAdapter newsAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String countryCode = "tr";
    
    public HomeFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.nisaefendioglu.newsapp.databinding.FragmentFeedBinding setBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nisaefendioglu.newsapp.ui.main.MainViewModel getMainViewModel() {
        return null;
    }
    
    public final void setMainViewModel(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.ui.main.MainViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nisaefendioglu.newsapp.ui.adapter.NewsAdapter getNewsAdapter() {
        return null;
    }
    
    public final void setNewsAdapter(@org.jetbrains.annotations.NotNull()
    com.nisaefendioglu.newsapp.ui.adapter.NewsAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCountryCode() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupUI() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupObservers() {
    }
    
    private final void showProgressBar() {
    }
    
    private final void hideProgressBar() {
    }
    
    private final void showErrorMessage(java.lang.String message) {
    }
    
    private final void hideErrorMessage() {
    }
    
    @java.lang.Override()
    public void onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu, @org.jetbrains.annotations.NotNull()
    android.view.MenuInflater inflater) {
    }
}