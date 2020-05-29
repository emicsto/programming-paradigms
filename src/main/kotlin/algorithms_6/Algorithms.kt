package algorithms_6

import algorithms_6.algorithms.FibonacciAlgorithm
import algorithms_6.algorithms.HanoiTowerAlgorithm
import algorithms_6.algorithms.QuicksortAlgorithm
import utils.formatToTimeString
import java.util.*
import kotlin.system.exitProcess

class Algorithms {

}

fun main() {
    println("[1] Ciąg Fibonacciego")
    println("[2] Wieże Hanoi")
    println("[3] Quicksort")
    print("Wybierz algorytm: ")

    val reader = Scanner(System.`in`)

    val algorithm = when (reader.nextInt()) {
        1 -> FibonacciAlgorithm()
        2 -> HanoiTowerAlgorithm()
        3 -> QuicksortAlgorithm()
        else -> exitProcess(1)
    }

    println("\n${algorithm.name}")
    print(algorithm.instruction)
    algorithm.n = reader.nextInt()

    println()
    println("Algorytm iteracyjny. Czas wykonania: ${algorithm.iterative().formatToTimeString()}")
    println("Algorytm rekurencyjny. Czas wykonania: ${algorithm.recursive().formatToTimeString()}")
}



