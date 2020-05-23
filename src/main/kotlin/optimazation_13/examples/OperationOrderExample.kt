package optimazation_13.examples

import kotlin.math.sqrt
import kotlin.system.measureTimeMillis

class OperationOrderExample(size: Int) : Example {

    private data class SquaredNumber(val initialValue: Int, val squaredValue: Long)

    private data class QuadrupledNumber(val initialValue: Int, val quadrupledValue: Long)

    private data class SquareRoot(val initialValue: Int, val squareRootValue: Double)

    override val name: String = "Kolejność operacji"

    private val list: List<SquaredNumber> = List(size) { index ->
        if(index == 0) {
            SquaredNumber(0, 1)
        } else {
            SquaredNumber(index, index.toLong() * index)
        }
    }

    override fun incorrectRun() = measureTimeMillis {
        list.filter { isDividableByTwo(it.initialValue) }.map(::createQuadruple).map(::createSquareRoot)
    }

    override fun correctRun(): Long = measureTimeMillis {
        list.map(::createQuadruple).map(::createSquareRoot).filter { isDividableByTwo(it.initialValue) }
    }

    private fun createQuadruple(squaredNumber: SquaredNumber): QuadrupledNumber {
        val quadrupledValue = squaredNumber.squaredValue * squaredNumber.squaredValue
        return QuadrupledNumber(squaredNumber.initialValue, quadrupledValue)
    }

    private fun createSquareRoot(quadrupledNumber: QuadrupledNumber) =
            SquareRoot(quadrupledNumber.initialValue, sqrt(quadrupledNumber.quadrupledValue.toDouble()))

    private fun isDividableByTwo(number: Int) = number % 2 == 0
}
