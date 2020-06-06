package algorithms

import kotlin.system.measureNanoTime

class HanoiTowerAlgorithm() : Algorithm {
    override val name = "Wieże Hanoi"
    override val instruction = "Podaj początkową liczbę krążków: "
    override var n: Int = 0

    override fun iterative(): Long = measureNanoTime {
        val limit = Math.pow(2.0, n.toDouble()).toInt() - 1
        for (i in 0 until limit) {
            val disk = disk(i)
            val source = movements(i, disk) * direction(disk, n) % 3
            val destination = (source + direction(disk, n)) % 3
        }
    }

    override fun recursive(): Long = measureNanoTime {
        val moves = 0
        computeHanoiTower(n, '1', '2', '3', moves)
    }

    private fun computeHanoiTower(n: Int, from: Char, to: Char, via: Char, moves: Int) {
        if (n > 0) {
            var movesCopy = moves
            computeHanoiTower(n - 1, from, via, to, movesCopy)
            computeHanoiTower(n - 1, via, to, from, ++movesCopy)
        }
    }

    private fun disk(i: Int): Int {
        var x = i + 1
        var C = 0
        while (x % 2 == 0) {
            x /= 2
            C++
        }
        return C
    }

    private fun movements(i: Int, d: Int): Int {
        var i = i
        var d = d
        while (d-- != 0) i /= 2
        return (i + 1) / 2
    }

    private fun direction(d: Int, n: Int): Int {
        return 2 - (n + d) % 2
    }
}
