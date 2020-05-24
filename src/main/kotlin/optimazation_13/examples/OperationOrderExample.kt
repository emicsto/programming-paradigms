package optimazation_13.examples

import kotlin.math.sqrt
import kotlin.system.measureNanoTime

class OperationOrderExample(size: Int) : Example {

    private data class SquaredNumber(val initialValue: Int, val squaredValue: Long)

    private data class QuadrupledNumber(val initialValue: Int, val quadrupledValue: Long)

    private data class SquareRoot(val initialValue: Int, val squareRootValue: Double)

    override val id: ExampleFactory.ExampleId = ExampleFactory.ExampleId.OPERATION_ORDER

    private val list: List<SquaredNumber> = List(size) { index ->
        if(index == 0) {
            SquaredNumber(0, 1)
        } else {
            SquaredNumber(index, index.toLong() * index)
        }
    }

    override fun incorrectRun() = measureNanoTime {
        list.map(::createQuadruple).map(::createSquareRoot).filter { isDividableByTwo(it.initialValue) }
    }

    override fun correctRun(): Long = measureNanoTime {
        list.filter { isDividableByTwo(it.initialValue) }.map(::createQuadruple).map(::createSquareRoot)
    }

    private fun createQuadruple(squaredNumber: SquaredNumber): QuadrupledNumber {
        val quadrupledValue = squaredNumber.squaredValue * squaredNumber.squaredValue
        return QuadrupledNumber(squaredNumber.initialValue, quadrupledValue)
    }

    private fun createSquareRoot(quadrupledNumber: QuadrupledNumber) =
            SquareRoot(quadrupledNumber.initialValue, sqrt(quadrupledNumber.quadrupledValue.toDouble()))

    private fun isDividableByTwo(number: Int) = number % 2 == 0
}