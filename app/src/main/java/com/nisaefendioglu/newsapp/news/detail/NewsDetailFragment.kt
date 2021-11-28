package com.nisaefendioglu.newsapp.news.detail
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.news_detail.*
import com.nisaefendioglu.newsapp.R
import com.nisaefendioglu.newsapp.data.model.resourse.Article
import loadImage

class NewsDetailFragment : Fragment() {

    private var item: Article? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.news_detail, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           // val bundle = NewsDetailFragmentArgs.fromBundle(it)
           // item = bundle.item
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        item?.let { article ->
            imgDetail.loadImage(article.urlToImage ?:"")
            titleDetail.text = article.title
            authorDetail.text = article.getAuthorName() ?: ""
            date.text = TimeConverter.getTimeAgo(article.publishedAt) ?: ""
            description.text = article.description
            article.content?.let { contentsDetail.text = Html.fromHtml(it) }

            webButon.setOnClickListener {
                val browserIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
                startActivity(browserIntent)

            }
        }
    }

}
