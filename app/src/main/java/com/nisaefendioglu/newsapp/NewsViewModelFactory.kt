
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nisaefendioglu.newsapp.ListRepository

class NewsViewModelFactory(
    private val application: Application,
    private val newsRepository: ListRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            Application::class.java,
            ListRepository::class.java
        ).newInstance(application, newsRepository)
    }
}