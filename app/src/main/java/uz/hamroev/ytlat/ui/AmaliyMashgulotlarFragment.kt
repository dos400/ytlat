package uz.hamroev.ytlat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.databinding.FragmentAmaliyMashgulotlarBinding

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

        return binding.root
    }

}