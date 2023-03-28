package uz.hamroev.ytlat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.databinding.FragmentFanningMeyoriyHujjatlariBinding

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




        return binding.root
    }


}