package uz.hamroev.ytlat.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import uz.hamroev.ytlat.databinding.ItemNavBinding
import uz.hamroev.ytlat.databinding.ItemUserBinding
import uz.hamroev.ytlat.databinding.ItemYouTubeBinding
import uz.hamroev.ytlat.models.Nav
import uz.hamroev.ytlat.models.User
import uz.hamroev.ytlat.models.YouTube

class YoutubeAdapter(
    var context: Context,
    var list: ArrayList<YouTube>,
) : RecyclerView.Adapter<YoutubeAdapter.VhYoutube>() {

    inner class VhYoutube(var itemYouTubeBinding: ItemYouTubeBinding) :
        RecyclerView.ViewHolder(itemYouTubeBinding.root) {

        fun onBind(vid: YouTube, position: Int) {
            itemYouTubeBinding.videoName.text = vid.videoName
            itemYouTubeBinding.youtubeView.addYouTubePlayerListener(object :
                AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    val vidId: String = vid.videoId
                    youTubePlayer.loadVideo(vidId, 0.0f)
                    youTubePlayer.pause()
                }
            })

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhYoutube {
        return VhYoutube(ItemYouTubeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VhYoutube, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnYoutubeListener{
        fun onPlay(youTube: YouTube, position: Int, view: View)
    }

}