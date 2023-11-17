package ru.rgt.unitconverter.datalayer

interface ConversionState {
    // First, we should be able to update state
    // whenever ui elements' state is changed.
    // We do so by implementing update() function which will be called on
    // every RadioButton update

    val allConversions: List<String>
    var conversionSrc: String
    var conversionDestinations: MutableList<String>
    fun update(newSrc: String)
}