package uz.hamroev.ytlat.ui.test

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.databinding.FragmentTestBinding
import uz.hamroev.ytlat.ui.test.data.TestData
import uz.hamroev.ytlat.ui.test.data.TestList
import uz.hamroev.ytlat.ui.test.data.Variant

class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!

    private var firstName: String = ""
    private var lastName: String = ""

    private var currentQuestion = 0
    private var totalQuestion = 29 // count number of questions -1
    private val selectedAnswers: List<TestData> by lazy {
        val list = TestList.loadQuestionsFromAssets(requireContext())
        list.forEach {
            it.answers = it.answers.shuffled() as ArrayList<Variant>
        }
        list.shuffled()
    }

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
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        loadData()
        binding.nextBtn.setOnClickListener {
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
        }
        binding.previousBtn.setOnClickListener {
            if (currentQuestion != 0) {
                selectedAnswers[currentQuestion].selectedAnswer = binding.answersGroup.checkedRadioButtonId
                currentQuestion--
                val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.previous_quetion)
                binding.questionContainer.startAnimation(anim)
                binding.answersGroup.clearCheck()
                loadData()
            }
        }
    }

    private fun loadData() {
        binding.questionNumberTv.text = "${currentQuestion + 1}/${totalQuestion + 1}"
        if (totalQuestion == currentQuestion)
            binding.nextBtn.text = requireContext().getString(R.string.finish)
        else binding.nextBtn.text = requireContext().getString(R.string.next)

        binding.questionTitleTv.text = selectedAnswers[currentQuestion].question
        binding.aAnswerTv.text = selectedAnswers[currentQuestion].answers[0].first
        binding.bAnswerTv.text = selectedAnswers[currentQuestion].answers[1].first
        binding.cAnswerTv.text = selectedAnswers[currentQuestion].answers[2].first
        binding.dAnswerTv.text = selectedAnswers[currentQuestion].answers[3].first
        if (selectedAnswers[currentQuestion].selectedAnswer != -1) {
            binding.answersGroup.check(selectedAnswers[currentQuestion].selectedAnswer)
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
        Toast.makeText(requireContext(), (correctAnswers).toString(), Toast.LENGTH_SHORT).show()
    }

    private fun openFormDialog() {
        val formDialog = FormDialog()
        formDialog.isCancelable = false
        formDialog.arguments = Bundle().apply {
            putSerializable("on_action_clicked", object : FormDialog.OnActionClicked {
                override fun start(firstName: String, lastName: String) {
                    this@TestFragment.firstName = firstName
                    this@TestFragment.lastName = lastName

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