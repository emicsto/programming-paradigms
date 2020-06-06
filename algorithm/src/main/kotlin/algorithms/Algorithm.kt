package algorithms

interface Algorithm {
    val name: String
    val instruction: String
    var n: Int

    fun recursive(): Long

    fun iterative(): Long
}
