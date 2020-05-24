package optimazation_13

import optimazation_13.examples.FindingElementExample
import optimazation_13.examples.OperationOrderExample
import optimazation_13.examples.PrimitiveCollectionExample

class Optimization {

}

fun main() {
    println("Optimization")

    val operationOrderExample = OperationOrderExample(30)
    println(operationOrderExample.correctRun())
    println(operationOrderExample.incorrectRun())

    println("=============")

    val findingElementExample = FindingElementExample(100, 10)
    println(findingElementExample.correctRun())
    println(findingElementExample.incorrectRun())

    println("=============")

    //Dopiero przy wartości 1_000_000_0 zaczyna mieć jakieś znaczenie, inaczej lista szybsza
    val collectionExample = PrimitiveCollectionExample(1_000_000_0)
    println(collectionExample.correctRun())
    println(collectionExample.incorrectRun())
}