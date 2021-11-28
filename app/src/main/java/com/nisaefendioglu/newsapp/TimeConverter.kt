
import java.text.SimpleDateFormat
import java.util.*

object TimeConverter {

    private const val SECOND_MILLIS = 1000
    private const val MINUTE_MILLIS = 60 * SECOND_MILLIS
    private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
    private const val DAY_MILLIS = 24 * HOUR_MILLIS
    private const val INPUT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'" // 2020-05-08T12:31:42Z


    fun getTimeAgo(time: String): String? {
        val inputFormat = SimpleDateFormat(INPUT_DATE_FORMAT)
        var date: Date? = null
        try {
            date = inputFormat.parse(time)
        } catch (e: Exception) {
            return ""
        }
        return getTimeAgoFromTimeStamp(date.time)
    }

    private fun getTimeAgoFromTimeStamp(timeStamp: Long): String {
        var time = timeStamp

        if (time < 1000000000000L) {
            time *= 1000
        }
        val now = System.currentTimeMillis()
        if (time > now || time <= 0) {
            return ""
        }
        val diff = now - time
        return if (diff < MINUTE_MILLIS) {
            "just now"
        } else if (diff < 2 * MINUTE_MILLIS) {
            "a minute ago"
        } else if (diff < 50 * MINUTE_MILLIS) {
            "${diff / MINUTE_MILLIS} minutes ago"
        } else if (diff < 90 * MINUTE_MILLIS) {
            "an hour ago"
        } else if (diff < 24 * HOUR_MILLIS) {
            "${diff / HOUR_MILLIS} hours ago"
        } else if (diff < 48 * HOUR_MILLIS) {
            "yesterday"
        } else {
            "${diff / DAY_MILLIS} days ago"
        }
    }
}