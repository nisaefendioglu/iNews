
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nisaefendioglu.newsapp.data.model.resourse.Article
import io.reactivex.disposables.CompositeDisposable

class ArticleDataSourceFactory(
    private val apiServiceService: ApiService,
    private val compositeDisposable: CompositeDisposable
) : DataSource.Factory<Int, Article>() {

    val newsLiveDataSource = MutableLiveData<ArticleDataSource>() 

    override fun create(): DataSource<Int, Article> {
        val newsDataSource =
            ArticleDataSource(
                apiServiceService,
                compositeDisposable
            )
        newsLiveDataSource.postValue(newsDataSource)
        return newsDataSource
    }
}