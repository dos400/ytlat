package uz.hamroev.ytlat.ui.test

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.cache.Cache
import uz.hamroev.ytlat.databinding.DialogResultBinding
import uz.hamroev.ytlat.databinding.FragmentTestBinding
import uz.hamroev.ytlat.ui.test.data.TestData
import uz.hamroev.ytlat.ui.test.data.TestList
import uz.hamroev.ytlat.ui.test.data.Variant

@SuppressLint("SuspiciousIndentation")
class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!

    private var firstName: String = ""
    private var lastName: String = ""

    private var currentQuestion = 0
    private var totalQuestion = 29 // count number of questions -1
    private lateinit var selectedAnswers: List<TestData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTestBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openFormDialog()

        lifecycleScope.launchWhenResumed {
            TestList.loadQuestionsFromAssets(requireContext()).collectLatest {
                val list = it
                list.forEach {
                    it.answers = it.answers.shuffled() as ArrayList<Variant>
                }
                selectedAnswers = list.shuffled()
            }
            delay(200)
            loadData()
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.nextBtn.setOnClickListener {
            try{
                if (currentQuestion == totalQuestion) {
                    selectedAnswers[currentQuestion].selectedAnswer = binding.answersGroup.checkedRadioButtonId
                    finish()
                } else if (currentQuestion < totalQuestion) {
                    selectedAnswers[currentQuestion].selectedAnswer =
                        binding.answersGroup.checkedRadioButtonId
                    currentQuestion++
                    val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.next_quetion)
                    binding.questionContainer.startAnimation(anim)
                    binding.answersGroup.clearCheck()
                    loadData()
                }
            }catch (ex:Exception){
                Toast.makeText(requireContext(), "Biror xatolik yuz berdi", Toast.LENGTH_SHORT).show()
            }
        }
        binding.previousBtn.setOnClickListener {
            try {
                if (currentQuestion != 0) {
                    selectedAnswers[currentQuestion].selectedAnswer = binding.answersGroup.checkedRadioButtonId
                    currentQuestion--
                    val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.previous_quetion)
                    binding.questionContainer.startAnimation(anim)
                    binding.answersGroup.clearCheck()
                    loadData()
                }
            }catch (ex:Exception){
                Toast.makeText(requireContext(), "Biror xatolik yuz berdi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadData() {
        try {
            binding.questionNumberTv.text = "${currentQuestion + 1}/${totalQuestion + 1}"
            if (totalQuestion == currentQuestion) {
                binding.nextBtn.text = requireContext().getString(R.string.finish)
            } else binding.nextBtn.text = requireContext().getString(R.string.next)

            binding.questionTitleTv.text = selectedAnswers[currentQuestion].question
            binding.aAnswerTv.text = selectedAnswers[currentQuestion].answers[0].first
            binding.bAnswerTv.text = selectedAnswers[currentQuestion].answers[1].first
            binding.cAnswerTv.text = selectedAnswers[currentQuestion].answers[2].first
            binding.dAnswerTv.text = selectedAnswers[currentQuestion].answers[3].first
            if (selectedAnswers[currentQuestion].selectedAnswer != -1) {
                binding.answersGroup.check(selectedAnswers[currentQuestion].selectedAnswer)
            }
        } catch (ex: Exception) {
            Log.e("TestFragment", ex.message.toString())
        }
    }

    private fun finish() {
        var correctAnswers = 0
        selectedAnswers.forEach {
            val selectedAnswer = when (it.selectedAnswer) {
                R.id.a_answer_tv -> 0
                R.id.b_answer_tv -> 1
                R.id.c_answer_tv -> 2
                R.id.d_answer_tv -> 3
                else -> -1
            }
            if (selectedAnswer!=-1) {
                if(it.answers[selectedAnswer].second) correctAnswers++
            }
        }
        // true answers count here
        setResult(correctAnswers)

//        Toast.makeText(requireContext(), (correctAnswers).toString()+" da", Toast.LENGTH_SHORT).show()
    }

    private fun setResult(correctAnswers: Int) {
        // will be dialog
        binding.apply {
            one.visibility = View.INVISIBLE
            two.visibility = View.INVISIBLE
        }
        val alertDialog = android.app.AlertDialog.Builder(binding.root.context)
        val dialog = alertDialog.create()
        val bindingResult =
            DialogResultBinding.inflate(LayoutInflater.from(requireContext()))
        dialog.setView(bindingResult.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)

        bindingResult.username.text = Cache.username.toString()!!
        bindingResult.userinfo.text = Cache.userinfo.toString()!!

        bindingResult.correctAnswer.text  = "${correctAnswers}/30"
        val a: Float = (correctAnswers.toFloat()/30.0f)
        val b = (a*100).toInt()
        bindingResult.correctAnswerWithPercantage.text = b.toString()+"%"

        bindingResult.again.setOnClickListener {
            dialog.dismiss()
            findNavController().popBackStack()
            findNavController().navigate(R.id.testFragment)
        }

        bindingResult.share.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_SUBJECT, "YTLAT")

                val shareMessage = "" +
                        "Ism: ${Cache.username}\n" +
                        "Qisqacha ma'lumot: ${Cache.username}\n" +
                        "\n" +
                        "To'g'ri javoblar soni: ${correctAnswers}/30\n" +
                        "To'g'ri javoblar foiz ko'rsatgichida: $b%\n" +
                        "\n\n" +
                        "Fan nomi: YER TUZISHNI LOYIHALASHNING AVTOMATLASHGAN TIZIMLARI \n\n" +
                        "================\n\n" +
                        "Ilova: https://play.google.com/store/apps/details?id=${activity?.packageName}\n"

                intent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(intent, "share by iAndroid.uz"))
            } catch (e: Exception) {
            }
        }



        dialog.show()


    }

    private fun openFormDialog() {
        binding.apply {
            one.visibility = View.GONE
            two.visibility = View.GONE
        }
        val formDialog = FormDialog()
        formDialog.isCancelable = false
        formDialog.arguments = Bundle().apply {
            putSerializable("on_action_clicked", object : FormDialog.OnActionClicked {
                override fun start(firstName: String, lastName: String) {
                    this@TestFragment.firstName = firstName
                    this@TestFragment.lastName = lastName

                    binding.apply {
                        one.visibility = View.VISIBLE
                        two.visibility = View.VISIBLE
                        Cache.username = firstName
                        Cache.userinfo = lastName
                    }
                    Log.d("TTTT", "start: $firstName $lastName")
                }

                override fun cancel() {
                    findNavController().popBackStack()
                }
            })
        }
        formDialog.show(parentFragmentManager, "form_dialog")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


