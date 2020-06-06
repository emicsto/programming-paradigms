package ui

class CLI: UI {

    override fun getUserInput(text: String): String {
        print(text)

        val input: String? = readLine()

        return input ?: ""
    }

    override fun showOutput(text: String) {
        println(text)
    }
}