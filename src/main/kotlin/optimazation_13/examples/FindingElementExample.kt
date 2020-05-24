package optimazation_13.examples

import kotlin.system.measureNanoTime

class FindingElementExample(size: Int, private val elementIndexToFind: Int) : Example {

    override val name: String = "Szukanie elementu"

    private val list: List<Int> = List(size) { it }
    private val sequence: Sequence<Int> = list.asSequence()

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
