package ru.rgt.unitconverter.datalayer

class WeightConversionState(
    override var conversionSrc: String,
    override var conversionDestinations: MutableList<String>,
    override val allConversions: List<String>
) : ConversionState {
    override fun update(newSrc: String) {
        if (newSrc != conversionSrc) {
            val changeIdx = conversionDestinations.indexOf(newSrc)
            conversionDestinations.removeAt(changeIdx)
            conversionDestinations.add(conversionSrc)
            conversionSrc = newSrc
        }
    }
}