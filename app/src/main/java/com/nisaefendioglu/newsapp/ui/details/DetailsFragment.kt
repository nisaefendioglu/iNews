package com.nisaefendioglu.newsapp.ui.details

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.nisaefendioglu.newsapp.base.BaseFragment
import com.nisaefendioglu.newsapp.databinding.FragmentDetailsBinding
import com.nisaefendioglu.newsapp.ui.main.MainActivity
import com.nisaefendioglu.newsapp.ui.main.MainViewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override fun setBinding(): FragmentDetailsBinding =
        FragmentDetailsBinding.inflate(layoutInflater)

    lateinit var viewModel: MainViewModel
    val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).mainViewModel
        setupUI(view)
        setupObserver();
    }

    private fun setupUI(view: View) {
        val news = args.news
        val isFromFavorite = args.isFromFavorite

        if (isFromFavorite) {
            binding.fab.visibility = View.GONE
        }

        binding.webView.apply {
            webViewClient = WebViewClient()
            news.url?.let {
                loadUrl(it)
            }
        }

        binding.fab.setOnClickListener {
            viewModel.saveNews(news)
            Snackbar.make(view, "News article saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupObserver() {
        viewModel.getFavoriteNews().observe(viewLifecycleOwner, { news ->
            val isAlreadyFavorite = news.any {
                it.title == args.news.title
            }
            if (isAlreadyFavorite) binding.fab.visibility = View.GONE
        })
    }
}