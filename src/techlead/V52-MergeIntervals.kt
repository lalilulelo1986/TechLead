package techlead

import kotlin.math.max
import kotlin.math.min

// print(merge(([1, 3], [5, 8], [4, 10], [20, 25])))
fun main() {
    val arr = arrayOf(1 to 3, 5 to 8, 4 to 10, 20 to 25)
    println(mergeIntervals(arr).toList())
    println(mergeIntervals2(arr).toList())
}

// my
fun mergeIntervals(array: Array<Pair<Int, Int>>): Array<Pair<Int, Int>> {
    val result = mutableListOf<Pair<Int, Int>>()
    val sorted = array.sortedBy { it.first }
    var start = sorted[0].first
    var end = sorted[0].second

    for (i in sorted.indices) {
        if (end >= sorted[i].first) {
            start = min(sorted[i].first, start)
            end = max(sorted[i].second, end)
        } else {
            result.add(start to end)
            start = sorted[i].first
            end = sorted[i].second
        }
    }
    result.add(start to end)

    return result.toTypedArray()
}

// TechLead
fun mergeIntervals2(array: Array<Pair<Int, Int>>): Array<Pair<Int, Int>> {
    val result = mutableListOf<Pair<Int, Int>>()

    array.sortedBy { it.first }.forEach {
        if (result.isNotEmpty() && result.last().second >= it.first) {
            val prev = result.last()
            result[result.size - 1] = prev.first to max(prev.second, it.second)
        } else {
            result.add(it.first to it.second)
        }
    }

    return result.toTypedArray()
}