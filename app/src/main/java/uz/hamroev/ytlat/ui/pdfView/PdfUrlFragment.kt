package uz.hamroev.ytlat.ui.pdfView

import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.DownloadListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ixuea.android.downloader.DownloadService
import com.ixuea.android.downloader.domain.DownloadInfo
import com.ixuea.android.downloader.exception.DownloadException
import uz.hamroev.ytlat.cache.Cache
import uz.hamroev.ytlat.databinding.FragmentPdfUrlBinding
import uz.hamroev.ytlat.util.extensions.invisible
import uz.hamroev.ytlat.util.extensions.toast
import uz.hamroev.ytlat.util.extensions.visible
import java.io.File


class PdfUrlFragment : Fragment() {


    lateinit var binding: FragmentPdfUrlBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPdfUrlBinding.inflate(layoutInflater)

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.toolbar.title = "Mavzular bo’yicha taqdimotlar"


        loadData()


        return binding.root
    }

    private fun loadData() {

        val downloadManager =
            DownloadService.getDownloadManager(binding.root.context?.applicationContext)
        var fileName = "presentation${Cache.mavzuNumber}"
        var url = ""
        when (Cache.mavzuNumber) {
            "1" -> {
                url =
                    "https://drive.google.com/u/0/uc?id=1sqDlIHmxqq-GtoB2ZElauFo9egW6YZ_J&export=download"
            }
            "2" -> {
                url = "https://drive.google.com/u/0/uc?id=1dKu0WCXLpk9DZ-Fvn984JjYs7kLC4Nug&export=download"
            }
            "3" -> {
                url = "https://drive.google.com/u/0/uc?id=1mxY_6CIxoHcgcbDV4FzRKojVPR6whRci&export=download"
            }
            "4" -> {
                url = "https://drive.google.com/u/0/uc?id=17maf2dz8AQorVtKMfTUzeTXp9wvJsa2h&export=download"
            }
            "5" -> {
                url = "https://drive.google.com/u/0/uc?id=1J7ZsLmawFmScwvoWu0Kn7kAitTNVdJ6h&export=download"
            }
            "6" -> {
                url = "https://drive.google.com/u/0/uc?id=1fBthp7wXLTOdXZijT0YDOQbijHD9BN9D&export=download"
            }
            "7" -> {
                url = "https://drive.google.com/u/0/uc?id=1FKJyp6-qoO5zUUMMZ8o5eIZKDqgiwTSC&export=download"
            }
            "8" -> {
                url = "https://drive.google.com/u/0/uc?id=1dcybvhReI1xfkTw7REVYRxrC8SrEovaV&export=download"
            }
            "9" -> {
                url = "https://drive.google.com/u/0/uc?id=1Yzhzvx5yxsezIFTw8toDoQmnqmk3Oh_w&export=download"
            }
            "10" -> {
                url = "https://drive.google.com/u/0/uc?id=14Aqwm-1t5lZs6qj_GXk_DQvm2U9pzK5Y&export=download"
            }
            "11" -> {
                url = "https://drive.google.com/u/0/uc?id=1nFgCrv0WvCkzIpPB6O9SrYH7A8eAOLeb&export=download"
            }
            "12" -> {
                url = "https://drive.google.com/u/0/uc?id=1_61V4ZULcu6PzSIs6guVi6y4u_jbvSaw&export=download"
            }
            "13" -> {
                url = "https://drive.google.com/u/0/uc?id=1_U1WPvWKQnmZLmhg42mc0itiVCJUULU_&export=download"
            }
            "14" -> {
                url = "https://drive.google.com/u/0/uc?id=1Q8Ou9UKEtTMBI60Pm60ZNAhZ5DtMLEqR&export=download"
            }
            "15" -> {
                url = "https://drive.google.com/u/0/uc?id=1n-BCh0dm6BFE6Aq833GK4pvVg3W_qdln&export=download"
            }
            "16" -> {
                url = "https://drive.google.com/u/0/uc?id=1kPcHAj6mCHXxv96b_5wHo3xu6j91SnXm&export=download"
            }
            "17" -> {
                url = "https://drive.google.com/u/0/uc?id=1KneowlOAI7VxZ-5mMlrbDFJz2JhGrEu7/&export=download"
            }
            "18" -> {
                url = "https://drive.google.com/u/0/uc?id=1YI_7ATNOdR9wLxzXH6t_xaosNQ0nTrh1&export=download"
            }
            "19" -> {
                url = "https://drive.google.com/u/0/uc?id=1h2YOxZVy4KNhU2SVlW8ns7NNML0gge65&export=download"
            }
            "20" -> {
                url = "https://drive.google.com/u/0/uc?id=141X2i_BWuVYB4-SRoB5bDZKHKu1aMXrN&export=download"
            }
            "21" -> {
                url = "https://drive.google.com/u/0/uc?id=11KEcug4sJVo98JckVMbl70RRIjhkAPTU&export=download"
            }
            "22" -> {
                url = "https://drive.google.com/u/0/uc?id=1PN5-A2Em7Skcy8rPyrGA5iW9m1S_dFxa&export=download"
            }
            "23" -> {
                url = "https://drive.google.com/u/0/uc?id=13O7q0G2mGRZfOEMcYrtgaE9WsR4pqUGp&export=download"
            }
            "24" -> {
                url = "https://drive.google.com/u/0/uc?id=1xXM56_9ZySbU9uNrnyKY3fm-M7t5G3op&export=download"
            }
            "25" -> {
                url = "https://drive.google.com/u/0/uc?id=1zhtWX0iYlAZoJ0chewBmQxv2SOxpf-S4&export=download"
            }
            "26" -> {
                url = "https://drive.google.com/u/0/uc?id=1Ohh63M5mDM8iG7HZu_jRs9PCmc8Yi6ZP&export=download"
            }
        }

        val targetFile =
            File(
                requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),
                "${fileName}.pdf"
            )

        if (targetFile.exists()) {
            binding.pdfView.fromFile(targetFile).show()
        } else {
            val downloadInfo = DownloadInfo.Builder()
                .setUrl(url)
                .setPath(targetFile.absolutePath)
                .build()

            downloadInfo.downloadListener =
                object : DownloadListener, com.ixuea.android.downloader.callback.DownloadListener {
                    override fun onDownloadStart(
                        url: String?,
                        userAgent: String?,
                        contentDisposition: String?,
                        mimetype: String?,
                        contentLength: Long,
                    ) {

                    }

                    override fun onStart() {
                        binding.progress.visible()
                    }

                    override fun onWaited() {

                    }

                    override fun onPaused() {
                        binding.progress.invisible()
                    }

                    override fun onDownloading(progress: Long, size: Long) {

                    }

                    override fun onRemoved() {

                    }

                    override fun onDownloadSuccess() {
                        binding.pdfView.fromFile(targetFile).show()
                        binding.progress.invisible()
                    }

                    override fun onDownloadFailed(e: DownloadException?) {
                        binding.progress.invisible()
                        toast(e?.printStackTrace().toString())
                    }

                }
            downloadManager.download(downloadInfo)
        }

    }


}