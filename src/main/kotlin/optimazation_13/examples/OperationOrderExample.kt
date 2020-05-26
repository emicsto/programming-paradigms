package optimazation_13.examples

import kotlin.math.sqrt
import kotlin.system.measureNanoTime

class OperationOrderExample(size: Int) : Example {

    private data class SquaredNumber(val squaredValue: Long)

    private data class QuadrupledNumber(val quadrupledValue: Long)

    private data class SquareRoot(val squareRootValue: Double)

    override val id: ExampleFactory.ExampleId = ExampleFactory.ExampleId.OPERATION_ORDER

    private val list: List<SquaredNumber> = List(size) { index ->
        if(index == 0) {
            SquaredNumber(1)
        } else {
            SquaredNumber(index.toLong() * index)
        }
    }

    override fun incorrectRun() = measureNanoTime {
        list
            .map(::createQuadruple)
            .map(::createSquareRoot)
            .filterIndexed { index, _ ->
                isDividableByTwo(index)
            }
    }

    override fun correctRun(): Long = measureNanoTime {
        list
            .filterIndexed { index, _ ->
                isDividableByTwo(index)
            }
            .map(::createQuadruple)
            .map(::createSquareRoot)
    }

    private fun createQuadruple(squaredNumber: SquaredNumber): QuadrupledNumber {
        val quadrupledValue = squaredNumber.squaredValue * squaredNumber.squaredValue
        return QuadrupledNumber(quadrupledValue)
    }

    private fun createSquareRoot(quadrupledNumber: QuadrupledNumber) =
        SquareRoot(sqrt(quadrupledNumber.quadrupledValue.toDouble()))

    private fun isDividableByTwo(number: Int) = number % 2 == 0
}
