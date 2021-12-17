package techlead

import java.util.*
import kotlin.math.sqrt

/*
print (findClosestPoints2([[1, 1], [3, 3], [2, 2], [4, 4], [-1, -1]], 3))
3 closest to x = 0; y = 0
 */
fun main() {
    val points = arrayOf(1 to 1, 3 to 3, 2 to 2, 4 to 4, -1 to -1)
    println(findClosest(points, 3))
    println(findClosest2(points, 3))
}

@OptIn(ExperimentalStdlibApi::class)
fun findClosest(array: Array<Pair<Int, Int>>, limit: Int): List<Pair<Int, Int>> {
    val heap = PriorityQueue<Pair<Double, Pair<Int, Int>>>(array.size) { a, b -> a.first.compareTo(b.first) }
    array.forEach { point ->
        heap.add((sqrt(point.first.toDouble() * point.first) + point.second.toDouble() * point.second) to point)
    }
    return buildList {
        repeat(limit) {
            add(heap.poll().second)
        }
    }
}

fun findClosest2(array: Array<Pair<Int, Int>>, limit: Int): List<Pair<Int, Int>> {
    val sorted = array.sortedBy { sqrt(it.first.toDouble() * it.first) + it.second.toDouble() * it.second }
    return sorted.take(limit)
}