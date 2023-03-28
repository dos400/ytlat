package uz.hamroev.ytlat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.databinding.FragmentMualliflarBinding

class MualliflarFragment : Fragment() {

    lateinit var binding: FragmentMualliflarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMualliflarBinding.inflate(layoutInflater)


        binding.imageMenuLayout.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }


}