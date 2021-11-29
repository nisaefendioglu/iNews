package com.nisaefendioglu.newsapp.ui.home
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nisaefendioglu.newsapp.R
import com.nisaefendioglu.newsapp.base.BaseFragment
import com.nisaefendioglu.newsapp.databinding.FragmentFeedBinding
import com.nisaefendioglu.newsapp.ui.adapter.NewsAdapter
import com.nisaefendioglu.newsapp.ui.main.MainActivity
import com.nisaefendioglu.newsapp.ui.main.MainViewModel
import com.nisaefendioglu.newsapp.utils.Constants
import com.nisaefendioglu.newsapp.utils.Constants.Companion.QUERY_PER_PAGE
import com.nisaefendioglu.newsapp.utils.EndlessRecyclerOnScrollListener
import com.nisaefendioglu.newsapp.utils.EspressoIdlingResource
import com.nisaefendioglu.newsapp.utils.NetworkResult


class HomeFragment : BaseFragment<FragmentFeedBinding>() {

    override fun setBinding(): FragmentFeedBinding =
        FragmentFeedBinding.inflate(layoutInflater)

    private lateinit var onScrollListener: EndlessRecyclerOnScrollListener
    lateinit var mainViewModel: MainViewModel
    lateinit var newsAdapter: NewsAdapter
    val countryCode = Constants.CountryCode

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = (activity as MainActivity).mainViewModel
        setupUI()
        setupRecyclerView()
        setupObservers()
        setHasOptionsMenu(true)
    }

    private fun setupUI() {
        EspressoIdlingResource.increment()
        binding.itemErrorMessage.btnRetry.setOnClickListener {
                mainViewModel.fetchNews(countryCode)
            hideErrorMessage()
        }

        // scroll listener for recycler view
        onScrollListener = object : EndlessRecyclerOnScrollListener(QUERY_PER_PAGE) {
            override fun onLoadMore() {

                    mainViewModel.fetchNews(countryCode)

            }
        }
//listeyi yenile
        val refreshListener = SwipeRefreshLayout.OnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            mainViewModel.fetchNews(countryCode)
        }
        binding.swipeRefreshLayout.setOnRefreshListener(refreshListener);

    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(onScrollListener)
        }
        newsAdapter.setOnItemClickListener { news ->
            val bundle = Bundle().apply {
                putSerializable("news", news)
                putBoolean("isFromFavorite", false)
            }
            findNavController().navigate(
                R.id.action_feedFragment_to_DetailsFragment,
                bundle
            )
        }
    }

    private fun setupObservers() {
        mainViewModel.newsResponse.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is NetworkResult.Success -> {
                    hideProgressBar()
                    hideErrorMessage()
                    response.data?.let { newResponse ->
                        EspressoIdlingResource.decrement()
                        newsAdapter.differ.submitList(newResponse.articles.toList())
                        mainViewModel.totalPage = newResponse.totalResults / QUERY_PER_PAGE + 1
                        onScrollListener.isLastPage =
                            mainViewModel.feedNewsPage == mainViewModel.totalPage + 1
                    }
                }

                is NetworkResult.Loading -> {
                    showProgressBar()
                }

                is NetworkResult.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        showErrorMessage(response.message)
                    }
                }
            }
        })

        mainViewModel.errorToast.observe(viewLifecycleOwner, Observer { value ->
            if (value.isNotEmpty()) {
                Toast.makeText(activity, value, Toast.LENGTH_LONG).show()
            } else {
                mainViewModel.hideErrorToast()
            }
        })
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showErrorMessage(message: String) {
        binding.itemErrorMessage.errorCard.visibility = View.VISIBLE
        binding.itemErrorMessage.tvErrorMessage.text = message
        onScrollListener.isError = true
    }

    private fun hideErrorMessage() {
        binding.itemErrorMessage.errorCard.visibility = View.GONE
        onScrollListener.isError = false
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

    }
}