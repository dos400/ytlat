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
        list.add(Mavzu("1","Taqdimot"))
        list.add(Mavzu("2","Taqdimot"))
        list.add(Mavzu("3","Taqdimot"))
        list.add(Mavzu("4","Taqdimot"))
        list.add(Mavzu("5","Taqdimot"))
        list.add(Mavzu("6","Taqdimot"))
        list.add(Mavzu("7","Taqdimot"))
        list.add(Mavzu("8","Taqdimot"))
        list.add(Mavzu("9","Taqdimot"))
        list.add(Mavzu("10","Taqdimot"))
        list.add(Mavzu("11","Taqdimot"))
        list.add(Mavzu("12","Taqdimot"))
        list.add(Mavzu("13","Taqdimot"))
        list.add(Mavzu("14","Taqdimot"))
        list.add(Mavzu("15","Taqdimot"))
        list.add(Mavzu("16","Taqdimot"))
        list.add(Mavzu("17","Taqdimot"))
        list.add(Mavzu("18","Taqdimot"))
        list.add(Mavzu("19","Taqdimot"))
        list.add(Mavzu("20","Taqdimot"))
        list.add(Mavzu("21","Taqdimot"))
        list.add(Mavzu("22","Taqdimot"))
        list.add(Mavzu("23","Taqdimot"))
        list.add(Mavzu("24","Taqdimot"))
        list.add(Mavzu("25","Taqdimot"))
        list.add(Mavzu("26","Taqdimot"))
        list.add(Mavzu("27","Taqdimot"))
        list.add(Mavzu("28","Taqdimot"))


        val mavzuAdapter =
            MavzuAdapter(binding.root.context, list, object : MavzuAdapter.OnMavzuClickListener {
                override fun onClick(mavzu: Mavzu, position: Int) {
                    Cache.position = position
                    Cache.mavzuNumber = mavzu.number
                    findNavController().navigate(R.id.pdfFragment)
                }
            })
        binding.rvMain.adapter = mavzuAdapter
    }


}