package uz.hamroev.ytlat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.adapters.MavzuAdapter
import uz.hamroev.ytlat.cache.Cache
import uz.hamroev.ytlat.databinding.FragmentMavzuBoyichaTaqdimotBinding
import uz.hamroev.ytlat.models.Mavzu

class MavzuBoyichaTaqdimotFragment : Fragment() {


    lateinit var binding: FragmentMavzuBoyichaTaqdimotBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMavzuBoyichaTaqdimotBinding.inflate(layoutInflater)

        Cache.pageName = "presentation"
        binding.imageMenuLayout.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.titleWindowTv.text = "Mavzular bo’yicha taqdimotlar"

        loadData()

        return binding.root
    }

    private fun loadData() {
        val list = ArrayList<Mavzu>()
        list.clear()
        list.add(Mavzu("1","Mavzu 1 - Ma'ruza 1"))
        list.add(Mavzu("2","Mavzu 1 - Ma'ruza 2"))
        list.add(Mavzu("3","Mavzu 2 - Ma'ruza 3"))
        list.add(Mavzu("4","Mavzu 2 - Ma'ruza 4"))
        list.add(Mavzu("5","Mavzu 2 - Ma'ruza 5"))
        list.add(Mavzu("6","Mavzu 3 - Ma'ruza 6"))
        list.add(Mavzu("7","Mavzu 3 - Ma'ruza 7"))
        list.add(Mavzu("8","Mavzu 3 - Ma'ruza 8"))
        list.add(Mavzu("9","Mavzu 4 - Ma'ruza 9"))
        list.add(Mavzu("10","Mavzu 4 - Ma'ruza 10-1"))
        list.add(Mavzu("11","Mavzu 4 - Ma'ruza 10"))
        list.add(Mavzu("12","Mavzu 4 - Ma'ruza 11"))
        list.add(Mavzu("13","Mavzu 5 - Ma'ruza 12"))
        list.add(Mavzu("14","Mavzu 5 - Ma'ruza 13"))
        list.add(Mavzu("15","Mavzu 5 - Ma'ruza 14"))
        list.add(Mavzu("16","Mavzu 6 - Ma'ruza 16"))
        list.add(Mavzu("17","Mavzu 6 - Ma'ruza 15"))
        list.add(Mavzu("18","Mavzu 7 - Ma'ruza 19"))
        list.add(Mavzu("19","Mavzu 7 - Ma'ruza 20"))
        list.add(Mavzu("20","Mavzu 7 - Ma'ruza 17"))
        list.add(Mavzu("21","Mavzu 7 - Ma'ruza 18"))
        list.add(Mavzu("22","Mavzu 8 - Ma'ruza 24"))
        list.add(Mavzu("23","Mavzu 8 - Ma'ruza 25"))
        list.add(Mavzu("24","Mavzu 8 - Ma'ruza 21"))
        list.add(Mavzu("25","Mavzu 8 - Ma'ruza 22"))
        list.add(Mavzu("26","Mavzu 8 - Ma'ruza 23"))


        val mavzuAdapter =
            MavzuAdapter(binding.root.context, list, object : MavzuAdapter.OnMavzuClickListener {
                override fun onClick(mavzu: Mavzu, position: Int) {
                    Cache.position = position
                    Cache.mavzuNumber = mavzu.number
                    findNavController().navigate(R.id.pdfUrlFragment)
                }
            })
        binding.rvMain.adapter = mavzuAdapter
    }


}