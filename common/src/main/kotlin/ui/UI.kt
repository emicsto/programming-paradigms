package ui

interface UI {

    fun getUserInput(text: String): String

    fun showOutput(text: String = "")

}