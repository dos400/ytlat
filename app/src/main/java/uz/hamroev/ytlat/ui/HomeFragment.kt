package uz.hamroev.ytlat.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.adapters.MainDepartmentAdapter
import uz.hamroev.ytlat.adapters.NavAdapter
import uz.hamroev.ytlat.databinding.FragmentHomeBinding
import uz.hamroev.ytlat.models.MainDepartment
import uz.hamroev.ytlat.models.Nav


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

        loadNavMenu()

        loadMainDepartment()




        return binding.root
    }

    private fun loadNavMenu() {
        val listNav = ArrayList<Nav>()
        listNav.clear()
        listNav.add(Nav("Asosiy", R.drawable.fi_home))

        listNav.add(Nav("Fanning me’yoriy hujjatlari", R.drawable.ic_fanning_meyoriy_hujjatlari))
        listNav.add(Nav("Ma’ruzalar mavzulari va matni", R.drawable.ic_maruza))
        listNav.add(Nav("Mavzular bo’yicha taqdimotlar", R.drawable.ic_taqdimot))
        listNav.add(Nav("Mavzular bo’yicha video darslar", R.drawable.ic_video))
        listNav.add(Nav("Mavzular bo’yicha amaliy mashg’ulotlar", R.drawable.ic_amaliy_mashgulot))
        listNav.add(Nav("Fanga oid glossariy va adabiyotlar", R.drawable.ic_glossariy2))
        listNav.add(Nav("Test sinovi", R.drawable.ic_test))

        listNav.add(Nav("Mualliflar", R.drawable.ic_users))

        listNav.add(Nav("Bo'lishish", R.drawable.fi_share_2))
        listNav.add(Nav("Baholash", R.drawable.fi_star))
        listNav.add(Nav("Chiqish", R.drawable.fi_log_out))

        val navAdapter =
            NavAdapter(binding.root.context, listNav, object : NavAdapter.OnNavClickListener {
                override fun onClick(nav: Nav, position: Int) {
                    when (position) {
                        0 -> {
                            binding.drawerLayout.close()
                        }
                        1 -> {
                            binding.drawerLayout.close()
                            findNavController().navigate(R.id.fanningMeyoriyHujjatlariFragment)
                        }
                        2 -> {
                            binding.drawerLayout.close()
                            findNavController().navigate(R.id.maruzaFragment)
                        }
                        3 -> {
                            binding.drawerLayout.close()
                            findNavController().navigate(R.id.mavzuBoyichaTaqdimotFragment)
                        }
                        4 -> {
                            binding.drawerLayout.close()
                            findNavController().navigate(R.id.mavzuBoyichaVideoFragment)
                        }
                        5 -> {
                            binding.drawerLayout.close()
                            findNavController().navigate(R.id.amaliyMashgulotlarFragment)
                        }
                        6 -> {
                            binding.drawerLayout.close()
                            findNavController().navigate(R.id.fangaOidGlossariyFragment)
                        }
                        7 -> {
                            binding.drawerLayout.close()
                            findNavController().navigate(R.id.testFragment)
                        }
                        8 -> {
                            binding.drawerLayout.close()
                            findNavController().navigate(R.id.mualliflarFragment)
                        }
                        9 -> {
                            /*share*/
                            try {
                                val intent = Intent(Intent.ACTION_SEND)
                                intent.type = "text/plain"
                                intent.putExtra(
                                    Intent.EXTRA_SUBJECT,
                                    "YTLAT"
                                )
                                val shareMessage =
                                    "https://play.google.com/store/apps/details?id=${activity?.packageName}"
                                intent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                                startActivity(
                                    Intent.createChooser(
                                        intent,
                                        "Yuborish uchun tanlang..."
                                    )
                                )
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                            binding.drawerLayout.close()
                        }
                        10 -> {
                            try {
                                val uri: Uri =
                                    Uri.parse("market://details?id=${activity?.packageName}")
                                val intent = Intent(Intent.ACTION_VIEW, uri)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                startActivity(intent)
                            } catch (e: ActivityNotFoundException) {
                                val uri: Uri =
                                    Uri.parse("http://play.google.com/store/apps/details?id=${activity?.packageName}")
                                val intent = Intent(Intent.ACTION_VIEW, uri)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                startActivity(intent)
                            }
                            binding.drawerLayout.close()
                        }
                        11 -> {
                            binding.drawerLayout.close()
                            findNavController().popBackStack()
                        }
                    }
                }
            })
        binding.rvNav.adapter = navAdapter
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
        listMain.add(MainDepartment("Mavzular bo’yicha taqdimotlar", R.drawable.ic_taqdimot))
        listMain.add(MainDepartment("Mavzular bo’yicha video darslar", R.drawable.ic_video))
        listMain.add(
            MainDepartment(
                "Mavzular bo’yicha amaliy mashg’ulotlar",
                R.drawable.ic_amaliy_mashgulot
            )
        )
        listMain.add(MainDepartment("Fanga oid glossariy va adabiyotlar", R.drawable.ic_glossariy2))
        listMain.add(MainDepartment("Test sinovi", R.drawable.ic_test))
        listMain.add(MainDepartment("Mualliflar haqida", R.drawable.ic_users))
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