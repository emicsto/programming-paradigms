package optimazation_13

import optimazation_13.examples.MutableCollectionExample
import optimazation_13.ui.UI

class Optimization(private val ui: UI) {
    fun start(){
        ui.showOutput("Opymalizacja ")
    }
}

fun main() {
    println("Optimization")

    val operationOrderExample = OperationOrderExample(30)
    println(operationOrderExample.correctRun())
    println(operationOrderExample.incorrectRun())

    println("=============")
    val mutableCollectionExample = MutableCollectionExample(5_000)
    println(mutableCollectionExample.correctRun())
    println(mutableCollectionExample.incorrectRun())


}