package algorithms_6.algorithms

import java.util.*
import kotlin.system.measureNanoTime

class QuicksortAlgorithm(n: Int) : Algorithm {
    override val name = "Quicksort"

    private var array = IntArray(n) { Random().nextInt() }
    var arrayAsList = array.asList()


    override fun recursive(): Long = measureNanoTime {
        computeQuickSort(arrayAsList)
    }

    override fun iterative(): Long = measureNanoTime {
        var l = 0
        var h = array.size - 1
        val stack = IntArray(h - l + 1)
        var top = -1
        stack[++top] = l
        stack[++top] = h
        while (top >= 0) {
            h = stack[top--]
            l = stack[top--]
            val p = partition(array, l, h)
            if (p - 1 > l) {
                stack[++top] = l
                stack[++top] = p - 1
            }
            if (p + 1 < h) {
                stack[++top] = p + 1
                stack[++top] = h
            }
        }
    }

    private fun <T : Comparable<T>> computeQuickSort(items: List<T>): List<T> {
        if (items.count() < 1) return items
        val pivot = items[items.count() / 2]
        val equal = items.filter { it == pivot }
        val less = items.filter { it < pivot }
        val greater = items.filter { it > pivot }
        return computeQuickSort(less) + equal + computeQuickSort(greater)
    }

    private fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = low - 1
        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp
        return i + 1
    }
}
