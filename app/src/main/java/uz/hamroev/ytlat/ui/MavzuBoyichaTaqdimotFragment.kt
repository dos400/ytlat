package uz.hamroev.ytlat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.databinding.FragmentMavzuBoyichaTaqdimotBinding

class MavzuBoyichaTaqdimotFragment : Fragment() {


    lateinit var binding: FragmentMavzuBoyichaTaqdimotBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMavzuBoyichaTaqdimotBinding.inflate(layoutInflater)

        binding.imageMenuLayout.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }


}