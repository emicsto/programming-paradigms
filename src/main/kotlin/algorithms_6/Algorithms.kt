package algorithms_6

import algorithms_6.algorithms.FibonacciAlgorithm
import algorithms_6.algorithms.HanoiTowerAlgorithm
import algorithms_6.algorithms.QuicksortAlgorithm
import java.util.*
import kotlin.system.exitProcess

class Algorithms {

}

fun main() {
    println("[1] Fibonacci sequence")
    println("[2] Hanoi tower problem")
    println("[3] Quicksort")
    print("Choose algorithm: ")

    val reader = Scanner(System.`in`)
    val chosenAlgorithm: Int = reader.nextInt()

    val algorithm = when (chosenAlgorithm) {
        1 -> FibonacciAlgorithm()
        2 -> HanoiTowerAlgorithm()
        3 -> QuicksortAlgorithm()
        else -> exitProcess(1)
    }

    println("\nYou selected " + algorithm.name)
    print(algorithm.instruction)
    val n: Int = reader.nextInt()
    algorithm.n = n

    println("Iterative (execution time in nanoseconds): " + algorithm.iterative())
    println("Recursion (execution time in nanoseconds): " + algorithm.recursive())
}

