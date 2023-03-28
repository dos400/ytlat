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
import uz.hamroev.ytlat.ui.test.data.TestDataList

class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!

    private var firstName: String = ""
    private var lastName: String = ""

    private var currentQuestion = 0
    private var totalQuestion = 2
    private val selectedAnswers :List<TestData> by lazy {
        TestDataList.list
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
                finish()
            } else if (currentQuestion < totalQuestion) {
                selectedAnswers[currentQuestion].selectedAnswer = binding.answersGroup.checkedRadioButtonId
                if(currentQuestion == totalQuestion){
                    binding.nextBtn.text = requireContext().getString(R.string.finish)
                }
                currentQuestion++
                val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.next_quetion)
                binding.questionContainer.startAnimation(anim)
                binding.questionTitleTv.text = selectedAnswers[currentQuestion].title
                binding.aAnswerTv.text = selectedAnswers[currentQuestion].a
                binding.bAnswerTv.text = selectedAnswers[currentQuestion].b
                binding.cAnswerTv.text = selectedAnswers[currentQuestion].c
                binding.dAnswerTv.text = selectedAnswers[currentQuestion].d
            }
            binding.questionNumberTv.text = "${currentQuestion + 1}/${totalQuestion + 1}"
        }
        binding.previousBtn.setOnClickListener {
            if (currentQuestion == totalQuestion - 1) {
                binding.nextBtn.text = requireContext().getString(R.string.next)
            }
            currentQuestion--
            val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.previous_quetion)
            binding.questionContainer.startAnimation(anim)
            binding.questionTitleTv.text = selectedAnswers[currentQuestion].title
            binding.aAnswerTv.text = selectedAnswers[currentQuestion].a
            binding.bAnswerTv.text = selectedAnswers[currentQuestion].b
            binding.cAnswerTv.text = selectedAnswers[currentQuestion].c
            binding.dAnswerTv.text = selectedAnswers[currentQuestion].d

            binding.questionNumberTv.text = "${currentQuestion + 1}/${totalQuestion + 1}"
        }
    }

    private fun loadData() {
        binding.questionTitleTv.text = selectedAnswers[currentQuestion].title
        binding.aAnswerTv.text = selectedAnswers[currentQuestion].a
        binding.bAnswerTv.text = selectedAnswers[currentQuestion].b
        binding.cAnswerTv.text = selectedAnswers[currentQuestion].c
        binding.dAnswerTv.text = selectedAnswers[currentQuestion].d
    }

    private fun finish() {
        var correctAnswers = 0
        selectedAnswers.forEach {
            if (it.selectedAnswer == it.correctAnswer) {
                correctAnswers++
            }
        }
        Toast.makeText(requireContext(), correctAnswers.toString(), Toast.LENGTH_SHORT).show()
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