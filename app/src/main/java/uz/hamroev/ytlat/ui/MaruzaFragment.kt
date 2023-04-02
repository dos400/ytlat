package uz.hamroev.ytlat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.databinding.FragmentMaruzaBinding

class MaruzaFragment : Fragment() {

    lateinit var binding: FragmentMaruzaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       binding = FragmentMaruzaBinding.inflate(layoutInflater)


        binding.imageMenuLayout.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.titleWindowTv.text = "Ma’ruzalar mavzulari va matni"

        return binding.root
    }


}