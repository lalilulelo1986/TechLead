package techlead

import java.util.*

fun main() {
    val inputArray = arrayOf(Pair(7, 0), Pair(4, 4), Pair(7, 1), Pair(5, 0), Pair(6, 1), Pair(5, 2))
    reQueue2(inputArray)
}

// SLOW
fun reQueue(array: Array<Pair<Int, Int>>): Array<Pair<Int, Int>?> {
    val result = Array<Pair<Int, Int>?>(array.size) { null }
    var nullCounter = 0
    Arrays.sort(array) { a, b -> if (a.first - b.first != 0) a.first - b.first else b.second - a.second }

    for (i in array.indices) {
        for (r in result.indices) {
            if (result[r] == null)
                nullCounter++
            if (array[i].second + 1 == nullCounter) {
                result[r] = array[i]
                nullCounter = 0
                break
            }
        }
    }

    array.forEach { println(it) }
    println()
    result.forEach { println(it) }
    return result
}

// with LinkedList
fun reQueue2(array: Array<Pair<Int, Int>>): LinkedList<Pair<Int, Int>> {
    val result = LinkedList<Pair<Int, Int>>()
    Arrays.sort(array) { a, b -> if (b.first - a.first != 0) b.first - a.first else a.second - b.second }

    for (i in array) {
        result.add(i.second, i)
    }

    array.forEach { println(it) }
    println(result)
    return result
}