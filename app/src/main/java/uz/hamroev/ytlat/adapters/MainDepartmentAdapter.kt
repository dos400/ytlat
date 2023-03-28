package uz.hamroev.ytlat.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.ytlat.databinding.ItemMainDepartmentBinding
import uz.hamroev.ytlat.models.MainDepartment

class MainDepartmentAdapter(
    context: Context,
    var list: ArrayList<MainDepartment>,
    var onCLickListener: OnCLickListener,
) :
    RecyclerView.Adapter<MainDepartmentAdapter.VhMain>() {

    inner class VhMain(var itemMainDepartmentBinding: ItemMainDepartmentBinding) :
        RecyclerView.ViewHolder(itemMainDepartmentBinding.root) {

        fun onBind(mainDepartment: MainDepartment, position: Int) {
            itemMainDepartmentBinding.apply {
                main.setOnClickListener {
                    onCLickListener.onClick(mainDepartment, position)
                }
                departmentTitle.text = mainDepartment.departmentName
                departmentImage.setImageResource(mainDepartment.departmentImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhMain {
        return VhMain(
            ItemMainDepartmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VhMain, position: Int) {
        return holder.onBind(list[position], position)
    }


    interface OnCLickListener {
        fun onClick(mainDepartment: MainDepartment, position: Int)
    }

}