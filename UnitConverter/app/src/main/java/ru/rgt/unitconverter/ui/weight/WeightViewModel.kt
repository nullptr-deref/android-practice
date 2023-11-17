package ru.rgt.unitconverter.ui.weight

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import ru.rgt.unitconverter.datalayer.WeightConversionState

class WeightViewModel() : ViewModel() {
    private var _state: WeightConversionState = WeightConversionState("g",
        mutableListOf("g", "kg", "t"),
        listOf("g", "kg", "t")
    )

    val text = MutableLiveData<String>(_state.conversionSrc)

    fun updateState(newSrc: String) {
        _state.update(newSrc)
        text.value = newSrc
    }
}