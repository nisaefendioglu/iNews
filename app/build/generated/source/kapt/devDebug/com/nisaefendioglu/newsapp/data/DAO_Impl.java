package com.nisaefendioglu.newsapp.data;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nisaefendioglu.newsapp.data.model.NewsArticle;
import com.nisaefendioglu.newsapp.data.model.Source;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAO_Impl implements DAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NewsArticle> __insertionAdapterOfNewsArticle;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<NewsArticle> __deletionAdapterOfNewsArticle;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllNews;

  public DAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNewsArticle = new EntityInsertionAdapter<NewsArticle>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `news` (`id`,`author`,`content`,`description`,`publishedAt`,`source`,`title`,`url`,`urlToImage`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NewsArticle value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getAuthor() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAuthor());
        }
        if (value.getContent() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getContent());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        if (value.getPublishedAt() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPublishedAt());
        }
        final String _tmp;
        _tmp = __converters.fromSource(value.getSource());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp);
        }
        if (value.getTitle() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTitle());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUrl());
        }
        if (value.getUrlToImage() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUrlToImage());
        }
      }
    };
    this.__deletionAdapterOfNewsArticle = new EntityDeletionOrUpdateAdapter<NewsArticle>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `news` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NewsArticle value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAllNews = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete FROM news";
        return _query;
      }
    };
  }

  @Override
  public Object upsert(final NewsArticle newsArticle,
      final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfNewsArticle.insertAndReturnId(newsArticle);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteNews(final NewsArticle newsArticle,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfNewsArticle.handle(newsArticle);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllNews(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllNews.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllNews.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<NewsArticle>> getAllNews() {
    final String _sql = "SELECT `news`.`id` AS `id`, `news`.`author` AS `author`, `news`.`content` AS `content`, `news`.`description` AS `description`, `news`.`publishedAt` AS `publishedAt`, `news`.`source` AS `source`, `news`.`title` AS `title`, `news`.`url` AS `url`, `news`.`urlToImage` AS `urlToImage` FROM news";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"news"}, false, new Callable<List<NewsArticle>>() {
      @Override
      public List<NewsArticle> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
          final List<NewsArticle> _result = new ArrayList<NewsArticle>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final NewsArticle _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpAuthor;
            _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            final String _tmpContent;
            _tmpContent = _cursor.getString(_cursorIndexOfContent);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpPublishedAt;
            _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
            final Source _tmpSource;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfSource);
            _tmpSource = __converters.toSource(_tmp);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpUrl;
            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            final String _tmpUrlToImage;
            _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
            _item = new NewsArticle(_tmpId,_tmpAuthor,_tmpContent,_tmpDescription,_tmpPublishedAt,_tmpSource,_tmpTitle,_tmpUrl,_tmpUrlToImage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
