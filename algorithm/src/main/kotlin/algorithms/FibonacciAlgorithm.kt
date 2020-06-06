package algorithms

import kotlin.system.measureNanoTime

class FibonacciAlgorithm() : Algorithm {
    override val name = "Ciąg Fibonacciego"
    override val instruction = "Podaj, która liczba w ciągu Fibonacciego powinna zostać znaleziona: "
    override var n: Int = 0

    override fun recursive(): Long = measureNanoTime { computeFibonacci(n) }

    private fun computeFibonacci(n: Int): Int = if (n < 2) n else computeFibonacci(n - 1) + computeFibonacci(n - 2)

    override fun iterative(): Long = measureNanoTime {
        var minusTwo = 0
        var minusOne = 1
        var result: Int
        for (i in 2..n) {
            result = minusOne + minusTwo
            minusTwo = minusOne
            minusOne = result
        }
    }
}
