package uz.hamroev.ytlat.ui.pdfView

import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ixuea.android.downloader.DownloadService
import com.ixuea.android.downloader.DownloadService.downloadManager
import com.ixuea.android.downloader.callback.DownloadListener
import com.ixuea.android.downloader.domain.DownloadInfo
import com.ixuea.android.downloader.exception.DownloadException
import uz.hamroev.ytlat.databinding.FragmentPdfUrlBinding
import java.io.File


class PdfUrlFragment : Fragment() {


    lateinit var binding: FragmentPdfUrlBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPdfUrlBinding.inflate(layoutInflater)

        binding.imageMenuLayout.setOnClickListener {
            findNavController().popBackStack()
        }

        loadData()


        return binding.root
    }

    private fun loadData() {

        val downloadManager =
            DownloadService.getDownloadManager(binding.root.context?.applicationContext)

        val targetFile =
            File(requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "6.pdf")
        val downloadInfo = DownloadInfo.Builder().setUrl("https://drive.google.com/u/0/uc?id=1sqDlIHmxqq-GtoB2ZElauFo9egW6YZ_J&export=download")
            .setPath(targetFile.absolutePath)
            .build()

//set download callback.

//set download callback.
        downloadInfo.downloadListener = object : DownloadListener {
            override fun onStart() {
                TODO("Not yet implemented")
            }

            override fun onWaited() {
                TODO("Not yet implemented")
            }

            override fun onPaused() {
                TODO("Not yet implemented")
            }

            override fun onDownloading(progress: Long, size: Long) {
                TODO("Not yet implemented")
            }

            override fun onRemoved() {
                TODO("Not yet implemented")
            }

            override fun onDownloadSuccess() {
                TODO("Not yet implemented")

            }

            override fun onDownloadFailed(e: DownloadException?) {
                TODO("Not yet implemented")
            }


        }

        downloadManager.download(downloadInfo)

        binding.pdfView.fromFile(targetFile).show()
    }


}