package optimazation_13

import optimazation_13.examples.Example
import optimazation_13.examples.ExampleFactory
import optimazation_13.examples.FindingElementExample
import optimazation_13.ui.CLI
import optimazation_13.ui.UI
import optimazation_13.utils.formatToTimeString
import kotlin.system.exitProcess

class Optimization(private val ui: UI, private val exampleFactory: ExampleFactory) {

    private sealed class State {
        object SelectionMenu: State()
        class AskForDescriptionSelected(val id: ExampleFactory.ExampleId): State()
        class ExampleSelected(val id: ExampleFactory.ExampleId): State()
        class ExampleReady(val example: Example): State()
    }

    private var state: State = State.SelectionMenu

    fun start(){
        ui.showOutput("Optymalizacja kodu źródłowego (Aby wyjść wpisz quit)")
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
            is State.ExampleReady -> handleExampleReadyState(currentState.example)
        }
    }

    private fun handleAskForDescriptionSelectedState(exampleId: ExampleFactory.ExampleId) {
        val userInput = getCorrectUserInput("Pokazać opis? (T/N): ", ::isCorrectChoiceInput)
        if(isChoicePositive(userInput)){
            ui.showOutput(exampleId.description)
        }

        state = State.ExampleSelected(exampleId)
    }

    private fun handleSelectionMenuState() {
        listAllPossibleExamples()
        selectExampleId()
    }

    private fun listAllPossibleExamples(){
        ui.showOutput()
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
        handleSpecialExampleCase(example)
        state = State.ExampleReady(example)
    }

    private fun getExampleListSize(): Int {
        val userInput = getCorrectUserInput("Podaj rozmiar listy: ", ::isCorrectListSize)

        return userInput.toInt()
    }

    private fun isCorrectListSize(input: String): Boolean {
        return isCorrectNumber(input) && input.toInt() < Integer.MAX_VALUE
    }

    private fun handleSpecialExampleCase(example: Example) {
        if(example is FindingElementExample){
            while (true){
                val userInput = getCorrectUserInput("Podaj element do wyszukania: ", ::isCorrectNumber)

                val wasIndexSet = example.setIndexToFind(userInput.toInt())
                if(wasIndexSet) {
                    break
                }
            }
        }
    }

    private fun isCorrectNumber(input: String): Boolean {
        return input.toIntOrNull() !== null
    }

    private fun handleExampleReadyState(example: Example) {
        ui.showOutput()

        ui.showOutput("Zła implementacja")
        val incorrectTime = example.incorrectRun()
        prettyPrintTime(incorrectTime)

        ui.showOutput("Dobra implementacja")
        val correctTime = example.correctRun()
        prettyPrintTime(correctTime)

        askToContinue(example.id)
    }

    private fun prettyPrintTime(time: Long){
        ui.showOutput("Czas wykonania: ${time.formatToTimeString()}")
        ui.showOutput()
    }

    private fun askToContinue(exampleId: ExampleFactory.ExampleId) {
        val userInput = getCorrectUserInput(
                "Powtórzyć algorytm z innym rozmiarem? (T/N): ",
                ::isCorrectChoiceInput
        )

        state = if(isChoicePositive(userInput)){
            State.ExampleSelected(exampleId)
        } else {
            State.SelectionMenu
        }
    }

    private fun isCorrectChoiceInput(string: String): Boolean = (isChoicePositive(string) || isChoiceNegative(string))

    private fun isChoicePositive(string: String): Boolean = (string.toLowerCase() == "t")

    private fun isChoiceNegative(string: String): Boolean = (string.toLowerCase() == "n")

    private fun getCorrectUserInput(inputText: String, predicateFunction: (String) -> Boolean): String {
        var inputCount = 0
        var userInput = ""
        while (!predicateFunction(userInput)){
            userInput = ui.getUserInput(inputText)

            if(userInput == "quit" || inputCount > 10){
                exitProcess(0)
            }

            inputCount++
        }

        return userInput
    }
}

fun main() {
    val ui = CLI()
    val examplesFactory = ExampleFactory()
    val optimization = Optimization(ui, examplesFactory)
    optimization.start()
}
