package uz.hamroev.ytlat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.hamroev.ytlat.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    lateinit var binding: FragmentTestBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTestBinding.inflate(layoutInflater, container, false)


        // for test



        return binding.root
    }


}