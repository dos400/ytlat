package uz.hamroev.ytlat.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.DialogFragment
import uz.hamroev.ytlat.R
import uz.hamroev.ytlat.databinding.DialogTestFormBinding
import uz.hamroev.ytlat.extensions.customSerializable
import java.io.Serializable

class FormDialog : DialogFragment() {

    private var _binding: DialogTestFormBinding? = null
    private val binding get() = _binding!!

    private var onActionClicked: OnActionClicked? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onActionClicked = arguments?.customSerializable("on_action_clicked")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogTestFormBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cancelBtn.setOnClickListener {
            dialog?.dismiss()
            onActionClicked?.cancel()
        }
        binding.firstNameEt.addTextChangedListener {
            binding.firstNameEt.error = null
        }
        binding.lastNameEt.addTextChangedListener {
            binding.lastNameEt.error = null
        }
        binding.startBtn.setOnClickListener {
            val firstName = binding.firstNameEt.text.toString().trim()
            val lastName = binding.lastNameEt.text.toString().trim()
            if (firstName.isEmpty()) {
                binding.firstNameEt.error = requireContext().getString(R.string.error_empty_field)
                return@setOnClickListener
            }
            if (lastName.isEmpty()) {
                binding.lastNameEt.error = requireContext().getString(R.string.error_empty_field)
                return@setOnClickListener
            }
            onActionClicked?.start(firstName, lastName)
            dialog?.dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun isCancelable(): Boolean = false

    override fun setCancelable(cancelable: Boolean) {
        super.setCancelable(false)
    }

    interface OnActionClicked : Serializable {
        fun start(firstName: String, lastName: String)
        fun cancel()
    }
}