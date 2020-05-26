package optimazation_13.examples

import kotlin.system.measureNanoTime

class FindingElementExample(private val size: Int) : Example {

    override val id: ExampleFactory.ExampleId = ExampleFactory.ExampleId.FINDING_ELEMENT

    var elementIndexToFind: Int = 0

    private val list: List<Int> = List(size) { it }
    private val sequence: Sequence<Int> = list.asSequence()

    //TODO use
    fun setIndexToFind(index: Int): Boolean =
            if(index in 0 until size){
                elementIndexToFind = index
                true
            } else {
                false
            }

    override fun incorrectRun() = measureNanoTime {
        list
                .map(::complicatedCalculation)
                .find { it == elementIndexToFind }
    }

    override fun correctRun(): Long = measureNanoTime {
        sequence
                .map(::complicatedCalculation)
                .find { it == elementIndexToFind }
    }

    private fun complicatedCalculation(number: Int): Int {
        Thread.sleep(1)
        return number
    }
}
