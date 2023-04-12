package uz.hamroev.ytlat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.hamroev.ytlat.adapters.MavzuAdapter
import uz.hamroev.ytlat.cache.Cache
import uz.hamroev.ytlat.databinding.FragmentAmaliyMashgulotlarBinding
import uz.hamroev.ytlat.models.Mavzu

class AmaliyMashgulotlarFragment : Fragment() {

    lateinit var binding: FragmentAmaliyMashgulotlarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAmaliyMashgulotlarBinding.inflate(layoutInflater)

        binding.imageMenuLayout.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.titleWindowTv.text = "Mavzular bo’yicha amaliy mashg’ulotlar"


        Cache.pageName = "amaliy mashgulot"
        loadAmaliyMashgulotlarMavzu()

        return binding.root
    }

    private fun loadAmaliyMashgulotlarMavzu() {
        val list = ArrayList<Mavzu>()
        list.clear()
        list.add(Mavzu("1", "Amaliy mashg'ulot"))
        list.add(Mavzu("2", "Amaliy mashg'ulot"))
        list.add(Mavzu("3", "Amaliy mashg'ulot"))
        list.add(Mavzu("4", "Amaliy mashg'ulot"))
        list.add(Mavzu("5", "Amaliy mashg'ulot"))
        list.add(Mavzu("6", "Amaliy mashg'ulot"))
        list.add(Mavzu("7", "Amaliy mashg'ulot"))
        list.add(Mavzu("8", "Amaliy mashg'ulot"))
        list.add(Mavzu("9", "Amaliy mashg'ulot"))
        list.add(Mavzu("10", "Amaliy mashg'ulot"))
        list.add(Mavzu("11", "Amaliy mashg'ulot"))
        list.add(Mavzu("12", "Amaliy mashg'ulot"))
        list.add(Mavzu("13", "Amaliy mashg'ulot"))
        list.add(Mavzu("14", "Amaliy mashg'ulot"))
        list.add(Mavzu("15", "Amaliy mashg'ulot"))
        list.add(Mavzu("16", "Amaliy mashg'ulot"))
        list.add(Mavzu("17", "Amaliy mashg'ulot"))
        list.add(Mavzu("18", "Amaliy mashg'ulot"))
        list.add(Mavzu("19", "Amaliy mashg'ulot"))
        list.add(Mavzu("20-21", "Amaliy mashg'ulot"))
        list.add(Mavzu("22", "Amaliy mashg'ulot"))
        list.add(Mavzu("23", "Amaliy mashg'ulot"))
        list.add(Mavzu("24-25", "Amaliy mashg'ulot"))
        list.add(Mavzu("26", "Amaliy mashg'ulot"))
        list.add(Mavzu("27", "Amaliy mashg'ulot"))
        list.add(Mavzu("28", "Amaliy mashg'ulot"))
        list.add(Mavzu("29", "Amaliy mashg'ulot"))
        list.add(Mavzu("30", "Amaliy mashg'ulot"))
        list.add(Mavzu("31", "Amaliy mashg'ulot"))
        list.add(Mavzu("32", "Amaliy mashg'ulot"))
        list.add(Mavzu("#", "Panorama dasturi bilan ishlash"))

        val mavzuAdapter =
            MavzuAdapter(binding.root.context, list, object : MavzuAdapter.OnMavzuClickListener {
                override fun onClick(mavzu: Mavzu, position: Int) {
                    Cache.position = position
                    Cache.mavzuNumber = mavzu.number
                    findNavController().navigate(uz.hamroev.ytlat.R.id.pdfUrlFragment)
                }
            })
        binding.rvMain.adapter = mavzuAdapter
    }


}