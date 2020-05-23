package algorithms_6

import algorithms_6.algorithms.FibonacciAlgorithm

class Algorithms {

}

fun main() {
    val fibonacci = FibonacciAlgorithm(10)
    println("Iterative " + fibonacci.iterative())
    println("Recursive " + fibonacci.recursive())
}

