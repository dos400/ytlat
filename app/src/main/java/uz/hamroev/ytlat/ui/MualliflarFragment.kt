package uz.hamroev.ytlat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.adapters.UserAdapter
import uz.hamroev.ytlat.databinding.FragmentMualliflarBinding
import uz.hamroev.ytlat.models.User

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
        binding.titleWindowTv.text = "Mualliflar haqida"

        loadAuthors()

        return binding.root
    }

    private fun loadAuthors() {
        val listAuthor = ArrayList<User>()
        listAuthor.clear()
        listAuthor.add(User("Muqumov \nAbdug‘ani \nMuratovich","1981 yilda TIQXMIIning Yer tuzish fakultetini tugatgan. Bugungi kunda “TIQXMMI” MTUning “Yer resurslarini boshqarish” kafedrasida faoliyat yuritadi. Faoliyati davrida 1 ta risola, 2 ta monografiya, 6 ta o‘quv qo‘llanma va 2 ta daslik chop etgan. 2022 yilning avgust oyida Turon fanlar akademiyasining faxriy professori unvonini olgan.",R.drawable.ic_abdugani))
        listAuthor.add(User("Xujakeldiev \nKomil \nNosirovich","1981 yili Toshkent irrigatsiya va qishloq xo‘jaligini mexanizatsiyalash injenerlari institutining  Qarshi filialini tugatgan. Bugungi kunda Qarshi muhandislik-iqtisodiyot institutining “Geodeziya, kadastr va yerdan  foydalanish” kafedrasida   faoliyat ko‘rsatmoqda. Texnika fanlari bo‘yicha falsafa doktori (PhD), dotsent.",R.drawable.ic_komil))
        listAuthor.add(User("Hamidov \nFayzullo \nRamazonovich","Toshkеnt irrigatsiya va qishloq xo‘jaligini mеxanizatsiyalash muhandislari instituti milliy tadqiqot unvеrsitеti buxoro tabiiy rеsurslarni boshqarish instituti dotsеnt. Gidromеlioratsiya fakultеti dеkani",R.drawable.ic_fayzullo))
        listAuthor.add(User("Adizov \nShuhrat \nBafoyevich\n", "Tayanch doktorant toshkеnt irrigatsiya va qishloq xo‘jaligini mеxanizatsiyalash muhandislari instituti milliy tadqiqot unvеrsitеti Buxoro tabiiy rеsurslarni boshqarish instituti yer rеsurslaridan foydalanish va davlat kadastrlari kafеdrasi o‘qituvchisi.",R.drawable.ic_shuhrat))

        val userAdapter = UserAdapter(binding.root.context, listAuthor)
        binding.rvUser.adapter = userAdapter

    }


}