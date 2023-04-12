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

        loadData()


        return binding.root
    }

    private fun loadData() {

        val downloadManager =
            DownloadService.getDownloadManager(binding.root.context?.applicationContext)

        val targetFile =
            File(requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "6.pdf")

        if (targetFile.exists()) {
            binding.pdfView.fromFile(targetFile).show()
        } else {
            val downloadInfo = DownloadInfo.Builder().setUrl("https://drive.google.com/u/0/uc?id=1sqDlIHmxqq-GtoB2ZElauFo9egW6YZ_J&export=download")
                .setPath(targetFile.absolutePath)
                .build()

            downloadInfo.downloadListener = object : DownloadListener, com.ixuea.android.downloader.callback.DownloadListener {
                override fun onDownloadStart(url: String?, userAgent: String?, contentDisposition: String?, mimetype: String?, contentLength: Long) {

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