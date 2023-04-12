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
import uz.hamroev.ytlat.databinding.FragmentFanningMeyoriyHujjatlariBinding
import uz.hamroev.ytlat.models.Mavzu

class FanningMeyoriyHujjatlariFragment : Fragment() {

    lateinit var binding: FragmentFanningMeyoriyHujjatlariBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFanningMeyoriyHujjatlariBinding.inflate(layoutInflater)

        binding.imageMenuLayout.setOnClickListener {
            findNavController().popBackStack()
        }

        Cache.pageName = "fanning hujjatlari"
        binding.titleWindowTv.text = "Fanning me’yoriy hujjatlari"


        loadData()

        return binding.root
    }

    private fun loadData() {
        val list = ArrayList<Mavzu>()
        list.clear()
        list.add(Mavzu("1","YTLAT fani o'quv dasturi"))
        list.add(Mavzu("2","YTLAT  fani  sillabusi"))


        val mavzuAdapter =
            MavzuAdapter(binding.root.context, list, object : MavzuAdapter.OnMavzuClickListener {
                override fun onClick(mavzu: Mavzu, position: Int) {
                    Cache.position = position
                    Cache.mavzuNumber = position.toString()
                    findNavController().navigate(R.id.pdfFragment)
                }
            })
        binding.rvMain.adapter = mavzuAdapter
    }


}