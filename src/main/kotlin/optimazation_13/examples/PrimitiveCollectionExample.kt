package optimazation_13.examples

import kotlin.system.measureNanoTime

class PrimitiveCollectionExample(size: Int) : Example {

    override val id: ExampleFactory.ExampleId = TODO()

    private val list: List<Int> = List(size) { it }
    private val intArray: IntArray = IntArray(size) { it }

    override fun incorrectRun() = measureNanoTime {
        list.average()
    }

    override fun correctRun(): Long = measureNanoTime {
        intArray.average()
    }

}
