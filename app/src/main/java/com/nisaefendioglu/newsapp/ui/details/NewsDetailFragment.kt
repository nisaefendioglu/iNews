/*url ile browser da açma işlemi
package com.nisaefendioglu.newsapp.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nisaefendioglu.newsapp.R
import com.nisaefendioglu.newsapp.data.model.NewsArticle
import java.sql.Time

class NewsDetailFragment : Fragment() {

    private var item: NewsArticle? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
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
            date.text = Time.getTimeAgo(article.publishedAt) ?: ""
            description.text = article.description
            article.content?.let { contentsDetail.text = Html.fromHtml(it) }

            webButon.setOnClickListener {
                val browserIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
                startActivity(browserIntent)

            }
        }
    }

}*/
