package uz.hamroev.ytlat.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.databinding.ItemMavzuBinding
import uz.hamroev.ytlat.models.Mavzu
import uz.hamroev.ytlat.util.extensions.anim

class MavzuAdapter(
    var context: Context,
    var list: ArrayList<Mavzu>,
    var onMavzuClickListener: OnMavzuClickListener,
) : RecyclerView.Adapter<MavzuAdapter.VhNav>() {

    inner class VhNav(var itemMavzuBinding: ItemMavzuBinding) :
        RecyclerView.ViewHolder(itemMavzuBinding.root) {

        fun onBind(mavzu: Mavzu, position: Int) {

            if (position%2 == 0){
                itemMavzuBinding.main.animation = context.anim(R.anim.anim_right)
            } else {
                itemMavzuBinding.main.animation = context.anim(R.anim.anim_left)
            }
            itemMavzuBinding.mavzuTitle.text = mavzu.title
            itemMavzuBinding.mavzuNumber.text = mavzu.number
            itemMavzuBinding.main.setOnClickListener {
                onMavzuClickListener.onClick(mavzu, position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhNav {
        return VhNav(ItemMavzuBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VhNav, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnMavzuClickListener {
        fun onClick(mavzu: Mavzu, position: Int)
    }
}