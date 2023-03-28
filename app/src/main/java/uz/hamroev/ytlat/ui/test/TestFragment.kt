package uz.hamroev.ytlat.ui.test

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!

    private var firstName: String = ""
    private var lastName: String = ""

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
        binding.nextBtn.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.next_quetion)
            binding.questionContainer.startAnimation(anim)
        }
        binding.previousBtn.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.previous_quetion)
            binding.questionContainer.startAnimation(anim)
        }
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