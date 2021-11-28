package com.nisaefendioglu.newsapp.news
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nisaefendioglu.newsapp.R
import com.nisaefendioglu.newsapp.data.Model
import com.nisaefendioglu.newsapp.data.ApiService
import com.nisaefendioglu.newsapp.data.NewsListRepository
import com.nisaefendioglu.newsapp.util.NetworkState
import com.nisaefendioglu.newsapp.viewmodel.NewsViewModel
import com.nisaefendioglu.newsapp.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.news_item_list.*
import javax.inject.Inject



@AndroidEntryPoint
class NewsListFragment : Fragment(),
    NewsPagedListAdapter.OnNewsItemClickListener {


    private lateinit var newsAdapter: NewsPagedListAdapter
    private lateinit var viewModel: NewsViewModel
    val photoRepository: NewsListRepository by lazy {
        NewsListRepository(apiServiceService)
    }

    @Inject
    lateinit var apiServiceService: ApiService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_item_list, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModel()

        setupPhotoList()
    }

    private fun setupPhotoList() {

        newsAdapter = NewsPagedListAdapter(this)
        with(news_list) {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
        }

        viewModel.newsPagedList.observe(viewLifecycleOwner, Observer {
            newsAdapter.submitList(it)
        })

        viewModel.networkState?.observe(viewLifecycleOwner, Observer {
            progress_bar.visibility =
                if (viewModel.isSearchListEmpty() && it == NetworkState.LOADING) View.VISIBLE else View.GONE
            txt_error.visibility =
                if (viewModel.isSearchListEmpty() && it == NetworkState.ERROR) View.VISIBLE else View.GONE

            if (!viewModel.isSearchListEmpty()) {
                newsAdapter.setNetworkState(it)
            }
        })


    }

    override fun onNewsItemClicked(
        model: Model?
    ) {
        model?.let {

            //findNavController().navigate(
              //NewsListFragmentDirections.actionNewslistFragmentToNewsDetailFragment(
                //  it
                //)
           //)
        }
    }

    private fun initViewModel() {
        activity?.let {
            viewModel = ViewModelProvider(
                it.viewModelStore,
                NewsViewModelFactory(it.application, photoRepository)
            ).get(NewsViewModel::class.java)
        }
    }

}