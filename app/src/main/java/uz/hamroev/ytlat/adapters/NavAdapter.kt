package uz.hamroev.ytlat.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.ytlat.databinding.ItemNavBinding
import uz.hamroev.ytlat.models.Nav

class NavAdapter(
    var context: Context,
    var list: ArrayList<Nav>,
    var onNavClickListener: OnNavClickListener,
) : RecyclerView.Adapter<NavAdapter.VhNav>() {

    inner class VhNav(var itemNavBinding: ItemNavBinding) :
        RecyclerView.ViewHolder(itemNavBinding.root) {

        fun onBind(nav: Nav, position: Int) {
            itemNavBinding.navNameTextView.text = nav.navName
            itemNavBinding.navIconImageView.setImageResource(nav.navIcon)
            itemNavBinding.main.setOnClickListener {
                onNavClickListener.onClick(nav, position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhNav {
        return VhNav(ItemNavBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VhNav, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnNavClickListener {
        fun onClick(nav: Nav, position: Int)
    }
}