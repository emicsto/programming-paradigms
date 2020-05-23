package algorithms_6.algorithms

import kotlin.system.measureNanoTime

class FibonacciAlgorithm(private val n: Int) : Algorithm {
    override val name = "Fibonacci"

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
