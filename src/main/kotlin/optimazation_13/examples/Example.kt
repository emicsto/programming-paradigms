package optimazation_13.examples

interface Example {

    val id: ExampleFactory.ExampleId

    fun correctRun(): Long

    fun incorrectRun(): Long

}