package algorithms_6.algorithms

interface Algorithm {
    val name: String

    fun recursive(): Long

    fun iterative(): Long
}
