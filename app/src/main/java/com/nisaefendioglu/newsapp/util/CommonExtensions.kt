
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.nisaefendioglu.newsapp.R


fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .placeholder(R.drawable.loading)
        .error(R.drawable.randomimage)
        .into(this)
}

fun ImageView.loadImage(uri: Uri) {
    Glide.with(this.context)
        .load(uri)
        .placeholder(R.drawable.loading)
        .error(R.drawable.randomimage)
        .into(this)
}