package algorithms_6

import algorithms_6.algorithms.FibonacciAlgorithm
import algorithms_6.algorithms.QuicksortAlgorithm

class Algorithms {

}

fun main() {
    val fibonacci = FibonacciAlgorithm(10)
    println("Iterative " + fibonacci.iterative())
    println("Recursive " + fibonacci.recursive())

    val quicksort = QuicksortAlgorithm(10)
    println("Iterative " + quicksort.iterative())
    println("Recursive " + quicksort.recursive())
}

