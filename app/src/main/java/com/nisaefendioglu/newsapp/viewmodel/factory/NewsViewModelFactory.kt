
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsViewModelFactory(
    private val application: Application,
    private val newsRepository: ArticlePagedListRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            Application::class.java,
            ArticlePagedListRepository::class.java
        ).newInstance(application, newsRepository)
    }
}