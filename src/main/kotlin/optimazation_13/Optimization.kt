package optimazation_13

import optimazation_13.examples.Example
import optimazation_13.examples.ExampleFactory
import optimazation_13.ui.CLI
import optimazation_13.ui.UI

class Optimization(private val ui: UI, private val exampleFactory: ExampleFactory) {

    private sealed class State {
        object SelectionMenu: State()
        class AskForDescriptionSelected(val id: ExampleFactory.ExampleId): State()
        class ExampleSelected(val id: ExampleFactory.ExampleId): State()
        class ExampleReady(val example: Example): State()
    }

    private var state: State = State.SelectionMenu

    fun start(){
        ui.showOutput("Optymalizacja kodu źródłowego")
        runLoop()
    }

    private fun runLoop(){
        while (true){
            handleState(state)
        }
    }

    private fun handleState(currentState: State) {
        when (currentState) {
            State.SelectionMenu -> handleSelectionMenuState()
            is State.AskForDescriptionSelected -> handleAskForDescriptionSelectedState(currentState.id)
            is State.ExampleSelected -> handleExampleSelectedState(currentState.id)
            is State.ExampleReady -> handleExampleCreatedState(currentState.example)
        }
    }

    private fun handleAskForDescriptionSelectedState(exampleId: ExampleFactory.ExampleId) {
        val userInput = getCorrectUserInput("Pokazać opis? (T/N)", ::isCorrectChoiceInput)
        val shouldShowDescription = userInput == "T"
        if(shouldShowDescription){
            ui.showOutput(exampleId.description)
        }

        state = State.ExampleSelected(exampleId)
    }

    private fun handleSelectionMenuState() {
        listAllPossibleExamples()
        selectExampleId()
    }

    private fun listAllPossibleExamples(){
        ExampleFactory.ExampleId.values().forEach { exampleId ->
            ui.showOutput("${exampleId.lp}. ${exampleId.title}")
        }
    }

    private fun selectExampleId() {
        val userInput = getCorrectUserInput("Podaj optymalizacje: ", ::isCorrectExample)

        val selectedExampleLp = userInput.toInt()
        val exampleId = ExampleFactory.ExampleId.values().find { it.lp == selectedExampleLp }
        state = if(exampleId != null){
            State.AskForDescriptionSelected(exampleId)
        } else {
            State.SelectionMenu
        }
    }

    private fun isCorrectExample(input: String): Boolean {
        val number = input.toIntOrNull() ?: return false
        return number in 1 .. ExampleFactory.ExampleId.values().count()
    }

    private fun handleExampleSelectedState(exampleId: ExampleFactory.ExampleId) {
        val size = getExampleListSize()
        val example = exampleFactory.getExample(exampleId, size)
        state = State.ExampleReady(example)
    }

    private fun getExampleListSize(): Int {
        val userInput = getCorrectUserInput("Podaj rozmiar listy: ", ::isCorrectListSize)

        return userInput.toInt()
    }

    private fun isCorrectListSize(input: String): Boolean {
        return input.toIntOrNull() !== null
    }

    private fun handleExampleCreatedState(example: Example) {
        println("Zła implementacja")
        val incorrectTime = example.incorrectRun()
        println("Czas wykonania: $incorrectTime")
        println()
        println("Dobra implementacja")
        val correctTime = example.correctRun()
        println("Czas wykonania: $correctTime")

        askToContinue(example.id)
    }

    private fun askToContinue(exampleId: ExampleFactory.ExampleId) {
        val userInput = getCorrectUserInput(
                "Powtórzyć algorytm z innym rozmiarem? (T/N)",
                ::isCorrectChoiceInput
        )

        state = if(userInput == "T"){
            State.ExampleSelected(exampleId)
        } else {
            State.SelectionMenu
        }
    }

    private fun isCorrectChoiceInput(string: String): Boolean = (string == "T" || string == "N")

    private fun getCorrectUserInput(inputText: String, predicateFunction: (String) -> Boolean): String {
        var userInput = ""
        while (!predicateFunction(userInput)){
            userInput = ui.getUserInput(inputText)
        }

        return userInput
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
