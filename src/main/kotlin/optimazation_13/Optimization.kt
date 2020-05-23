package optimazation_13

import optimazation_13.examples.FindingElementExample
import optimazation_13.examples.OperationOrderExample

class Optimization {

}

fun main() {
    println("Optimization")

    val operationOrderExample = OperationOrderExample(30000000)
    println(operationOrderExample.correctRun())
    println(operationOrderExample.incorrectRun())

    val findingElementExample = FindingElementExample(1000, 100)
    println(findingElementExample.correctRun())
    println(findingElementExample.incorrectRun())
}