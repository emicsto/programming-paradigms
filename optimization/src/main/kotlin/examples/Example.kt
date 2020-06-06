package examples

interface Example {

    val id: ExampleFactory.ExampleId

    fun correctRun(): Long

    fun incorrectRun(): Long

}