package com.nisaefendioglu.newsapp.news
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nisaefendioglu.newsapp.R
import com.nisaefendioglu.newsapp.data.Model
import com.nisaefendioglu.newsapp.util.NetworkState
import com.nisaefendioglu.newsapp.util.Time
import com.nisaefendioglu.newsapp.util.loadImage
import kotlinx.android.synthetic.main.item_news.view.*

class NewsPagedListAdapter(val listener: OnNewsItemClickListener) :
    PagedListAdapter<Model, RecyclerView.ViewHolder>(diffCallback()) {

    val PHOTO_VIEW_TYPE = 1
    val NETWORK_VIEW_TYPE = 2

    private var networkState: NetworkState? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View

        if (viewType == PHOTO_VIEW_TYPE) {
            view = layoutInflater.inflate(R.layout.item_news, parent, false)
            return ArticleItemViewHolder(view)
        } else {
            view = layoutInflater.inflate(R.layout.item_news, parent, false)
            return ArticleItemViewHolder(view)        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == PHOTO_VIEW_TYPE) {
            (holder as ArticleItemViewHolder).bind(getItem(position))
        } else {

        }
    }


    private fun hasExtraRow(): Boolean {
        return networkState != null && networkState != NetworkState.LOADED
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasExtraRow()) 1 else 0
    }

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            NETWORK_VIEW_TYPE
        } else {
            PHOTO_VIEW_TYPE
        }
    }


    class diffCallback : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem == newItem
        }

    }


    inner class ArticleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img_news_item: ImageView = itemView.img_news_item
        val txt_news_item_time_ago: TextView = itemView.txt_news_item_time_ago
        val txt_news_item_title: TextView = itemView.txt_news_item_title
        val txt_news_item_des: TextView = itemView.txt_news_item_des
        val txt_news_item_source: TextView = itemView.txt_news_item_source

        fun bind(model: Model?) {

            itemView.setOnClickListener { listener.onNewsItemClicked(model) }

            model?.let {
                img_news_item.loadImage(it.urlToImage ?:"")
                txt_news_item_title.text = it.title
                txt_news_item_des.text = it.description
                txt_news_item_source.text = it.getAuthorName()
                txt_news_item_time_ago.text = Time.getTimeAgo(it.publishedAt)
            }
        }

    }



    fun setNetworkState(newNetworkState: NetworkState) {
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()
        this.networkState = newNetworkState
        val hasExtraRow = hasExtraRow()

        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount())
            } else {
                notifyItemInserted(super.getItemCount())
            }
        } else if (hasExtraRow && previousState != newNetworkState) {
            notifyItemChanged(itemCount - 1)
        }

    }

    interface OnNewsItemClickListener {
        fun onNewsItemClicked(
            item: Model?
        )
    }

}