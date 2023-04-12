package uz.hamroev.ytlat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.adapters.MavzuAdapter
import uz.hamroev.ytlat.cache.Cache
import uz.hamroev.ytlat.databinding.FragmentMaruzaBinding
import uz.hamroev.ytlat.models.Mavzu

class MaruzaFragment : Fragment() {

    lateinit var binding: FragmentMaruzaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       binding = FragmentMaruzaBinding.inflate(layoutInflater)

        Cache.pageName = "maruza"

        binding.imageMenuLayout.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.titleWindowTv.text = "Ma’ruzalar mavzulari va matni"
        loadData()

        return binding.root
    }

    private fun loadData() {
        val list = ArrayList<Mavzu>()
        list.clear()
        list.add(Mavzu("1","Ma'ruza"))
        list.add(Mavzu("2","Ma'ruza"))
        list.add(Mavzu("3","Ma'ruza"))
        list.add(Mavzu("4","Ma'ruza"))
        list.add(Mavzu("5","Ma'ruza"))


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