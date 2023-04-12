package uz.hamroev.ytlat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.adapters.YoutubeAdapter
import uz.hamroev.ytlat.databinding.FragmentMavzuBoyichaVideoBinding
import uz.hamroev.ytlat.models.YouTube

class MavzuBoyichaVideoFragment : Fragment() {

    lateinit var binding: FragmentMavzuBoyichaVideoBinding
    lateinit var listVideo: ArrayList<YouTube>
    lateinit var youtubeAdapter: YoutubeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMavzuBoyichaVideoBinding.inflate(layoutInflater)


        binding.imageMenuLayout.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.titleWindowTv.text = "Mavzular bo’yicha video darslar"

        loadVideoList()
        youtubeAdapter = YoutubeAdapter(binding.root.context, listVideo)
        binding.rvMain.adapter = youtubeAdapter

        return binding.root
    }

    private fun loadVideoList() {
        listVideo = ArrayList()
        listVideo.clear()
        listVideo.add(YouTube("4pkltxcN44Y", "Yer tuzishni loyihalashning avtomatlashgan tizimlari va uning yer tuzish tizimidagi o’rni"))
        listVideo.add(YouTube("ZkMYeXofCLg", "Yer tuzishni loyihalashning avtomatlashgan tizimini yaratishning asosiy tamoyillari "))
        listVideo.add(YouTube("mM4zSVuQ4Jk", "Dastur va jixozlar ta'minoti vositalari klassifikatsiyasi "))
        listVideo.add(YouTube("wuV7vaatL04", "YTLATni yaratishning konseptual asoslari va tamoyillari"))
        listVideo.add(YouTube("bW_FEdxEB_I", "Avtomatlashgan tarzda yer tuzishni loyihalashning umumiy texnologik chizmasi "))
        listVideo.add(YouTube("tQlLVOxXlNs", "YTLATni va uning elementlarini loyihalashga qo'yiladigan asosiy talablar"))
        listVideo.add(YouTube("iXVXDxk77P4", "YTLATni yaratishning asosiy tamoyillari "))
        listVideo.add(YouTube("8w-gHtz8Hzk", "YTLAT tarkibi va asosiy elementlarning vazifalari "))
        listVideo.add(YouTube("7WJF-IvDeN0", "YTLAT tarkibi"))
        listVideo.add(YouTube("B-idqBEUdpU", "Yer tuzishda ekspert tizimlari "))
        listVideo.add(YouTube("0IMZpTcgJIM", "YTLAT va GATda grafika "))
        listVideo.add(YouTube("KGvuyGcF9WU", "Ekspert tizimlarini yaratish texnologiyalari "))
        listVideo.add(YouTube("rlMybpnYb7Y", "Yer tuzishda ekspert tizimlaridan foydalanish kelajagi "))
        listVideo.add(YouTube("UPFg5m7Y8v8", "Exspert tizimlariga zamonaviy yondoshuvlar "))
        listVideo.add(YouTube("cgcGS4oFygg", "Yer tuzish va yer kadastri ishlarida avtomatlashgan tizimlardan foydalanish "))
        listVideo.add(YouTube("iLLdNV2a0Ig", "PANORAMA majmuasidan yer tuzish va yer kadastri ishlarini avtomatlashtirishda foydalanish "))


    }

    override fun onDestroy() {
        super.onDestroy()
        loadVideoList()
        youtubeAdapter = YoutubeAdapter(binding.root.context, listVideo)
        binding.rvMain.adapter = youtubeAdapter
    }


}