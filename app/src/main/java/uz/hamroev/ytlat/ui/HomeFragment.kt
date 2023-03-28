package uz.hamroev.ytlat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.adapters.MainDepartmentAdapter
import uz.hamroev.ytlat.databinding.FragmentHomeBinding
import uz.hamroev.ytlat.models.MainDepartment


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.imageMenuLayout.setOnClickListener {
            binding.drawerLayout.open()
        }

        loadMainDepartment()




        return binding.root
    }

    private fun loadMainDepartment() {
        val listMain = ArrayList<MainDepartment>()
        listMain.clear()
        listMain.add(MainDepartment("Fanning me’yoriy hujjatlari", R.drawable.ic_fanning_meyoriy_hujjatlari))
        listMain.add(MainDepartment("Ma’ruzalar mavzulari va matni", R.drawable.ic_maruza))
        listMain.add(MainDepartment("Mavzular bo’yicha taqdimotlar", R.drawable.ic_fanning_meyoriy_hujjatlari))
        listMain.add(MainDepartment("Mavzular bo’yicha video darslar", R.drawable.ic_fanning_meyoriy_hujjatlari))
        listMain.add(MainDepartment("Mavzular bo’yicha amaliy mashg’ulotlar", R.drawable.ic_amaliy_mashgulot))
        listMain.add(MainDepartment("Fanga oid glossariy va adabiyotlar", R.drawable.ic_fanning_meyoriy_hujjatlari))
        listMain.add(MainDepartment("Test sinovi", R.drawable.ic_fanning_meyoriy_hujjatlari))
        listMain.add(MainDepartment("Mualliflar haqida", R.drawable.ic_fanning_meyoriy_hujjatlari))
        val mainDepartmentAdapter = MainDepartmentAdapter(
            binding.root.context,
            listMain,
            object : MainDepartmentAdapter.OnCLickListener {
                override fun onClick(mainDepartment: MainDepartment, position: Int) {
                    when (position) {
                        0 -> {}
                        1 -> {}
                        2 -> {}
                        3 -> {}
                        4 -> {}
                        5 -> {}
                        6 -> {}
                    }
                }
            })
        binding.rvMain.adapter = mainDepartmentAdapter
    }


}