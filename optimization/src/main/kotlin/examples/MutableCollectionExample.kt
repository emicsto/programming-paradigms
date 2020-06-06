package examples

import kotlin.system.measureNanoTime

class MutableCollectionExample(size: Int) : Example {

    override val id: ExampleFactory.ExampleId =
        ExampleFactory.ExampleId.MUTABLE_COLLECTION

    private val list: List<Int> = List(size) { it }

    override fun incorrectRun() = measureNanoTime {
        list
                .map { it*it }
                .map { it / 2 }
                .map { 3 * it }
    }

    override fun correctRun(): Long = measureNanoTime {
        val mutableList = mutableListOf<Int>()
        list.forEach {
            val squared = it * it
            val dividedByTwo = squared / 2
            val multipliedByThree = 3 * dividedByTwo
            mutableList.add(multipliedByThree)
        }
    }

}
