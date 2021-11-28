
import NetworkModule.ITEM_PER_PAGE
import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.nisaefendioglu.newsapp.data.model.resourse.Article
import io.reactivex.disposables.CompositeDisposable

class ArticlePagedListRepository(private val apiServiceService: ApiService) {

    lateinit var newsPagedList: LiveData<PagedList<Article>>
    lateinit var articleDataSourceFactory: ArticleDataSourceFactory

    fun fetchLiveSearchArticlePagedList(
        compositeDisposable: CompositeDisposable
    ): LiveData<PagedList<Article>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(ITEM_PER_PAGE)
            .build()

        articleDataSourceFactory = ArticleDataSourceFactory(
            apiServiceService,
            compositeDisposable
        )

        newsPagedList = LivePagedListBuilder(articleDataSourceFactory, config).build()
        return newsPagedList
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap(newsPagedList, Function {
            articleDataSourceFactory.newsLiveDataSource.value?.networkState
        })
    }
}