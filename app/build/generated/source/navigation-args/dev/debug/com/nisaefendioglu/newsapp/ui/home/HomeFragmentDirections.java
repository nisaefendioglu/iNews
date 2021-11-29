package com.nisaefendioglu.newsapp.ui.home;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.nisaefendioglu.newsapp.R;
import com.nisaefendioglu.newsapp.data.model.NewsArticle;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static ActionFeedFragmentToDetailsFragment actionFeedFragmentToDetailsFragment(
      @NonNull NewsArticle news, boolean isFromFavorite) {
    return new ActionFeedFragmentToDetailsFragment(news, isFromFavorite);
  }

  public static class ActionFeedFragmentToDetailsFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionFeedFragmentToDetailsFragment(@NonNull NewsArticle news, boolean isFromFavorite) {
      if (news == null) {
        throw new IllegalArgumentException("Argument \"news\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("news", news);
      this.arguments.put("isFromFavorite", isFromFavorite);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFeedFragmentToDetailsFragment setNews(@NonNull NewsArticle news) {
      if (news == null) {
        throw new IllegalArgumentException("Argument \"news\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("news", news);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFeedFragmentToDetailsFragment setIsFromFavorite(boolean isFromFavorite) {
      this.arguments.put("isFromFavorite", isFromFavorite);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("news")) {
        NewsArticle news = (NewsArticle) arguments.get("news");
        if (Parcelable.class.isAssignableFrom(NewsArticle.class) || news == null) {
          __result.putParcelable("news", Parcelable.class.cast(news));
        } else if (Serializable.class.isAssignableFrom(NewsArticle.class)) {
          __result.putSerializable("news", Serializable.class.cast(news));
        } else {
          throw new UnsupportedOperationException(NewsArticle.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      if (arguments.containsKey("isFromFavorite")) {
        boolean isFromFavorite = (boolean) arguments.get("isFromFavorite");
        __result.putBoolean("isFromFavorite", isFromFavorite);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_feedFragment_to_DetailsFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public NewsArticle getNews() {
      return (NewsArticle) arguments.get("news");
    }

    @SuppressWarnings("unchecked")
    public boolean getIsFromFavorite() {
      return (boolean) arguments.get("isFromFavorite");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionFeedFragmentToDetailsFragment that = (ActionFeedFragmentToDetailsFragment) object;
      if (arguments.containsKey("news") != that.arguments.containsKey("news")) {
        return false;
      }
      if (getNews() != null ? !getNews().equals(that.getNews()) : that.getNews() != null) {
        return false;
      }
      if (arguments.containsKey("isFromFavorite") != that.arguments.containsKey("isFromFavorite")) {
        return false;
      }
      if (getIsFromFavorite() != that.getIsFromFavorite()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getNews() != null ? getNews().hashCode() : 0);
      result = 31 * result + (getIsFromFavorite() ? 1 : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionFeedFragmentToDetailsFragment(actionId=" + getActionId() + "){"
          + "news=" + getNews()
          + ", isFromFavorite=" + getIsFromFavorite()
          + "}";
    }
  }
}
