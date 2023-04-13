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
import uz.hamroev.ytlat.databinding.FragmentFangaOidGlossariyBinding
import uz.hamroev.ytlat.models.Mavzu

class FangaOidGlossariyFragment : Fragment() {


    lateinit var binding: FragmentFangaOidGlossariyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFangaOidGlossariyBinding.inflate(layoutInflater)


        binding.imageMenuLayout.setOnClickListener {
            findNavController().popBackStack()
        }

        Cache.pageName = "Fanga oid glossariy va adabiyotlar"
        binding.titleWindowTv.text = "Fanga oid glossariy va adabiyotlar"

        loadData()

        return binding.root
    }

    private fun loadData() {
        val list = ArrayList<Mavzu>()
        list.clear()
        list.add(Mavzu("1","Fanga oid glossariy"))
        list.add(Mavzu("2","Fanga oid adabiyotlar"))


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