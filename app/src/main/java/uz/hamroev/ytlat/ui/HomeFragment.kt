package uz.hamroev.ytlat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.adapters.MainDepartmentAdapter
import uz.hamroev.ytlat.databinding.FragmentHomeBinding
import uz.hamroev.ytlat.models.MainDepartment


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findNavController().navigate(R.id.testFragment)
    }

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
        listMain.add(
            MainDepartment(
                "Fanning me’yoriy hujjatlari",
                R.drawable.ic_fanning_meyoriy_hujjatlari
            )
        )
        listMain.add(MainDepartment("Ma’ruzalar mavzulari va matni", R.drawable.ic_maruza))
//        listMain.add(MainDepartment("Mavzular bo’yicha taqdimotlar", R.drawable.ic_taqdimot))
//        listMain.add(MainDepartment("Mavzular bo’yicha video darslar", R.drawable.ic_video))
        listMain.add(
            MainDepartment(
                "Mavzular bo’yicha amaliy mashg’ulotlar",
                R.drawable.ic_amaliy_mashgulot
            )
        )
        listMain.add(MainDepartment("Fanga oid glossariy va adabiyotlar", R.drawable.ic_glossariy))
//        listMain.add(MainDepartment("Test sinovi", R.drawable.ic_test))
//        listMain.add(MainDepartment("Mualliflar haqida", R.drawable.ic_users))
        val mainDepartmentAdapter = MainDepartmentAdapter(
            binding.root.context,
            listMain,
            object : MainDepartmentAdapter.OnCLickListener {
                override fun onClick(mainDepartment: MainDepartment, position: Int) {
                    when (position) {
                        0 -> {
                            findNavController().navigate(R.id.fanningMeyoriyHujjatlariFragment)
                        }
                        1 -> {
                            findNavController().navigate(R.id.maruzaFragment)
                        }
                        2 -> {
                            findNavController().navigate(R.id.mavzuBoyichaTaqdimotFragment)
                        }
                        3 -> {
                            findNavController().navigate(R.id.mavzuBoyichaVideoFragment)
                        }
                        4 -> {
                            findNavController().navigate(R.id.amaliyMashgulotlarFragment)
                        }
                        5 -> {
                            findNavController().navigate(R.id.fangaOidGlossariyFragment)
                        }
                        6 -> {
                            findNavController().navigate(R.id.testFragment)
                        }
                        7 -> {
                            findNavController().navigate(R.id.mualliflarFragment)
                        }
                    }
                }
            })
        binding.rvMain.adapter = mainDepartmentAdapter
    }


}