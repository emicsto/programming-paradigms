package optimazation_13

import optimazation_13.examples.ExampleFactory
import optimazation_13.ui.CLI
import optimazation_13.ui.UI

class Optimization(private val ui: UI, private val exampleFactory: ExampleFactory) {
    fun start(){
        ui.showOutput("Optymalizacja kodu źródłowego")
        listAllPossibleExamples()
        tryToSelectExample()
    }

    private fun listAllPossibleExamples(){
        ExampleFactory.ExampleId.values().forEach { exampleId ->
            ui.showOutput("${exampleId.lp}. ${exampleId.title}")
        }
    }

    private fun tryToSelectExample() {
        var userInput = ""
        while (!isCorrectExample(userInput)){
            userInput = ui.getUserInput("Podaj optymalizacje: ")
        }
        println("wybrał $userInput")
    }

    private fun isCorrectExample(input: String): Boolean {
        val number = input.toIntOrNull() ?: return false
        return number in 1 .. ExampleFactory.ExampleId.values().count()
    }
}

fun main() {
    val ui = CLI()
    val examplesFactory = ExampleFactory()
    val optimization = Optimization(ui, examplesFactory)
    optimization.start()

//    val operationOrderExample = OperationOrderExample(30)
//    println(operationOrderExample.correctRun())
//    println(operationOrderExample.incorrectRun())
//
//    println("=============")
//
//    val findingElementExample = FindingElementExample(100, 10)
//    println(findingElementExample.correctRun())
//    println(findingElementExample.incorrectRun())
//
//    println("=============")
//
//    //Dopiero przy wartości 1_000_000_0 zaczyna mieć jakieś znaczenie, inaczej lista szybsza
//    val primitiveCollectionExample = PrimitiveCollectionExample(1_000_000_0)
//    println(primitiveCollectionExample.correctRun())
//    println(primitiveCollectionExample.incorrectRun())

//    println("=============")
//    val mutableCollectionExample = MutableCollectionExample(5_000)
//    println(mutableCollectionExample.correctRun())
//    println(mutableCollectionExample.incorrectRun())


}