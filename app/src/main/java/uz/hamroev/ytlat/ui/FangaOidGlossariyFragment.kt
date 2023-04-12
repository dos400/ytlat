package uz.hamroev.ytlat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.databinding.FragmentFangaOidGlossariyBinding

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

        binding.titleWindowTv.text = "Fanga oid glossariy va adabiyotlar"
        binding.pdfView.fromAsset("pdf_glossariy.pdf").show()

        return binding.root
    }


}