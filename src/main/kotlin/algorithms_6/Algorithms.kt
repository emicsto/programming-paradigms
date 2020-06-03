package algorithms_6

import algorithms_6.algorithms.Algorithm
import algorithms_6.algorithms.FibonacciAlgorithm
import algorithms_6.algorithms.HanoiTowerAlgorithm
import algorithms_6.algorithms.QuicksortAlgorithm
import utils.formatToTimeString
import java.util.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    val reader = Scanner(System.`in`)

    var input = ""

    while (true) {
        do {
            showMenu()
            input = reader.nextLine()
            if (input == "q") exitProcess(0)
        } while (!isValidInput(input))

        val algorithm = when (input.toInt()) {
            1 -> FibonacciAlgorithm()
            2 -> HanoiTowerAlgorithm()
            3 -> QuicksortAlgorithm()
            else -> exitProcess(1)
        }

        println("\n${algorithm.name}")

        do {
            print(algorithm.instruction)
            input = reader.nextLine()
        } while (!isValidInput(input))

        algorithm.n = input.toInt()

        showResults(algorithm)
    }

}

fun isValidInput(str: String?) = str?.toIntOrNull()?.let { true } ?: false

private fun showMenu() {
    println("[1] Ciąg Fibonacciego")
    println("[2] Wieże Hanoi")
    println("[3] Quicksort")
    println("[q] Wyjście")
    print("Wybierz algorytm: ")
}

private fun showResults(algorithm: Algorithm) {
    println("\nAlgorytm iteracyjny. Czas wykonania: ${algorithm.iterative().formatToTimeString()}")
    println("Algorytm rekurencyjny. Czas wykonania: ${algorithm.recursive().formatToTimeString()}\n\n")
}






