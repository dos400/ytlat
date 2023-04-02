package uz.hamroev.ytlat.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.ytlat.databinding.ItemNavBinding
import uz.hamroev.ytlat.databinding.ItemUserBinding
import uz.hamroev.ytlat.models.Nav
import uz.hamroev.ytlat.models.User

class UserAdapter(
    var context: Context,
    var list: ArrayList<User>
) : RecyclerView.Adapter<UserAdapter.VhUser>() {

    inner class VhUser(var itemUserBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(itemUserBinding.root) {

        fun onBind(user: User, position: Int) {
            itemUserBinding.authorName.text = user.name
            itemUserBinding.authorAbout.text = user.info
            itemUserBinding.authorImage.setImageResource(user.img)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhUser {
        return VhUser(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VhUser, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}