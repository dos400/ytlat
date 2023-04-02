package uz.hamroev.ytlat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.databinding.FragmentMavzuBoyichaVideoBinding

class MavzuBoyichaVideoFragment : Fragment() {

    lateinit var binding: FragmentMavzuBoyichaVideoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMavzuBoyichaVideoBinding.inflate(layoutInflater)


        binding.imageMenuLayout.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.titleWindowTv.text = "Mavzular bo’yicha video darslar"

        return binding.root
    }


}