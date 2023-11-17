package ru.rgt.unitconverter.ui.weight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.rgt.unitconverter.databinding.FragmentWeightBinding

class WeightFragment : Fragment() {

    private var _binding: FragmentWeightBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ViewModelProvider(this).get(WeightViewModel::class.java)

        _binding = FragmentWeightBinding.inflate(inflater, container, false)
        val textView: TextView = binding.unitsWeight
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val radioGroup = binding.radioWeights
        radioGroup.setOnCheckedChangeListener { rg, _ ->
            val checkedBtnId = rg.checkedRadioButtonId
            val checkedButton = binding.root.findViewById<RadioButton>(checkedBtnId)
            viewModel.updateState(checkedButton.text.toString())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}