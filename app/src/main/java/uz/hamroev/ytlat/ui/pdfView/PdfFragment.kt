package uz.hamroev.ytlat.ui.pdfView

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.cache.Cache
import uz.hamroev.ytlat.databinding.FragmentPdfBinding

class PdfFragment : Fragment() {


    lateinit var binding: FragmentPdfBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPdfBinding.inflate(layoutInflater)

        binding.imageMenuLayout.setOnClickListener {
            findNavController().popBackStack()
        }
        Handler(Looper.getMainLooper()).postDelayed({
            binding.progress.visibility = View.GONE
        }, 700)

        loadPage()

        return binding.root
    }

    private fun loadPage() {
        when (Cache.pageName) {
            "amaliy mashgulot" -> {
                binding.titleWindowTv.text = "Mavzular bo’yicha amaliy mashg’ulotlar"
                loadAmaliyMashgulot()
            }
            "fanning hujjatlari" -> {
                binding.titleWindowTv.text = "Fanning me’yoriy hujjatlari"
                loadHujjatlar()
            }
            "maruza" -> {
                binding.titleWindowTv.text = "Ma’ruzalar mavzulari va matni"
                loadMaruza()
            }
            "presentation" ->{
                binding.titleWindowTv.text = "Mavzular bo’yicha taqdimotlar"
                loadPresentation()
            }
        }
    }

    private fun loadPresentation() {
        when(Cache.mavzuNumber){
            "1" ->{

            }
        }
    }

    private fun loadMaruza() {
        when (Cache.mavzuNumber) {
            "1" -> {
                binding.pdfView.fromAsset("mavzu1maruza1.pdf").show()
            }
            "2" -> {
                binding.pdfView.fromAsset("mavzu1maruza2.pdf").show()
            }
            "3" -> {
                binding.pdfView.fromAsset("mavzu2maruza3.pdf").show()
            }
            "4" -> {
                binding.pdfView.fromAsset("mavzu2maruza4.pdf").show()
            }
            "5" -> {
                binding.pdfView.fromAsset("mavzu2maruza5.pdf").show()
            }
        }
    }

    private fun loadHujjatlar() {
        when (Cache.mavzuNumber) {
            "0" -> {
                binding.pdfView.fromAsset("fanning_meyoriy_hujjati1.pdf").show()
            }
            "1" -> {
                binding.pdfView.fromAsset("fanning_meyoriy_hujjati2_sillabus.pdf").show()
            }

        }
    }

    private fun loadAmaliyMashgulot() {
        when (Cache.mavzuNumber) {
            "1" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot1.pdf").show()
            }
            "2" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot2.pdf").show()
            }
            "3" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot3.pdf").show()
            }
            "4" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot4.pdf").show()
            }
            "5" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot5.pdf").show()
            }
            "6" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot6.pdf").show()
            }
            "7" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot7.pdf").show()
            }
            "8" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot8.pdf").show()
            }
            "9" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot9.pdf").show()
            }
            "10" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot10.pdf").show()
            }
            "11" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot11.pdf").show()
            }
            "12" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot12.pdf").show()
            }
            "13" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot13.pdf").show()
            }
            "14" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot14.pdf").show()
            }
            "15" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot15.pdf").show()
            }
            "16" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot16.pdf").show()
            }
            "17" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot17.pdf").show()
            }
            "18" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot18.pdf").show()
            }
            "19" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot19.pdf").show()
            }

            "20-21" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot20_21.pdf").show()
            }

            "22" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot22.pdf").show()
            }
            "23" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot23.pdf").show()
            }
            "24-25" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot24_25.pdf").show()
            }

            "26" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot26.pdf").show()
            }
            "27" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot27.pdf").show()
            }
            "28" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot28.pdf").show()
            }
            "29" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot29.pdf").show()
            }
            "30" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot30.pdf").show()
            }
            "31" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot31.pdf").show()
            }
            "32" -> {
                binding.pdfView.fromAsset("amaliy_mashgulot32.pdf").show()
            }
            "#" -> {
                binding.pdfView.fromAsset("panorama_dasturi_bilan_ishlash.pdf").show()
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}