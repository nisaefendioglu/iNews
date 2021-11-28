
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nisaefendioglu.newsapp.NetworkState
import com.nisaefendioglu.newsapp.NewsArticle
import kotlinx.android.synthetic.main.item_network_state.view.*
import kotlinx.android.synthetic.main.item_news.view.*


class NewsPagedListAdapter(val listener: OnNewsItemClickListener) :
    PagedListAdapter<NewsArticle, RecyclerView.ViewHolder>(diffCallback()) {

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
            view = layoutInflater.inflate(R.layout.item_network_state, parent, false)
            view.tag = listener
            return NetworkStateItemViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == PHOTO_VIEW_TYPE) {
            (holder as ArticleItemViewHolder).bind(getItem(position))
        } else {
            (holder as NetworkStateItemViewHolder).bind(networkState)
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


    class diffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }


    inner class ArticleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img_news_item: ImageView = itemView.img_news_item
        val txt_news_item_time_ago: TextView = itemView.txt_news_item_time_ago
        val txt_news_item_title: TextView = itemView.txt_news_item_title
        val txt_news_item_des: TextView = itemView.txt_news_item_des
        val txt_news_item_source: TextView = itemView.txt_news_item_source

        fun bind(article: NewsArticle?) {

            itemView.setOnClickListener { listener.onNewsItemClicked(article) }

            article?.let {
                img_news_item.loadImage(it.urlToImage ?:"")
                txt_news_item_title.text = it.title
                txt_news_item_des.text = it.description
                txt_news_item_source.text = it.getAuthorName()
                txt_news_item_time_ago.text = TimeConverter.getTimeAgo(it.publishedAt)
            }
        }

    }

    class NetworkStateItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(networkState: NetworkState?) {
            if (networkState != null && networkState == NetworkState.LOADING) {
                itemView.progress_bar_item.visibility = View.VISIBLE
            } else {
                itemView.progress_bar_item.visibility = View.GONE
            }

            if (networkState != null && networkState == NetworkState.ERROR) {
                itemView.error_msg_item.visibility = View.VISIBLE
                itemView.error_msg_item.text = networkState.msg
            } else if (networkState != null && networkState == NetworkState.ENDOFLIST) {
                itemView.error_msg_item.visibility = View.VISIBLE
                itemView.error_msg_item.text = networkState.msg
            } else {
                itemView.error_msg_item.visibility = View.GONE
            }
        }
    }


    fun setNetworkState(newNetworkState: NetworkState) {
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()
        this.networkState = newNetworkState
        val hasExtraRow = hasExtraRow()

        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {                             //hadExtraRow is true and hasExtraRow false
                notifyItemRemoved(super.getItemCount())    //remove the progressbar at the end
            } else {                                       //hasExtraRow is true and hadExtraRow false
                notifyItemInserted(super.getItemCount())   //add the progressbar at the end
            }
        } else if (hasExtraRow && previousState != newNetworkState) { //hasExtraRow is true and hadExtraRow true and (NetworkState.ERROR or NetworkState.ENDOFLIST)
            notifyItemChanged(itemCount - 1)       //add the network message at the end
        }

    }

    interface OnNewsItemClickListener {
        fun onNewsItemClicked(
            item: NewsArticle?
        )
    }

}