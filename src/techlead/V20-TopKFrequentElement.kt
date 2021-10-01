package techlead

import java.util.*
import kotlin.collections.HashMap

/*
*  [1,1,1,3,2,2] k = 2
*  result = [1,2]
* */

fun main() {
    val array = arrayOf(1, 1, 1, 3, 2, 2, 5, 5, 5)
    val k = 2
    println(MySolution20.topKFreq(array, k).toList())

    println(HeapSolution.topKFreq(array, k).toList())
}

class MySolution20 {
    companion object {
        fun topKFreq(array: Array<Int>, k: Int): Array<Int> {
            val hashMap = HashMap<Int, Int>()
            for (a in array) {
                hashMap.computeIfPresent(a) { _, v -> v + 1 }
                hashMap.putIfAbsent(a, 1)
            }
            val topFreqNumbers = hashMap.values.sortedDescending().take(2)
            return hashMap.filter { e -> e.value in topFreqNumbers }.keys.take(2).toTypedArray()
        }
    }
}

// Using java PriorityQueue(Heap)
class HeapSolution {
    companion object {
        @OptIn(ExperimentalStdlibApi::class)
        fun topKFreq(array: Array<Int>, k: Int): Array<Int> {
            val hashMap = HashMap<Int, Int>()
            for (a in array) {
                hashMap.computeIfPresent(a) { _, v -> v + 1 }
                hashMap.putIfAbsent(a, 1)
            }

            val pq = PriorityQueue<Pair<Int, Int>> { a, b -> b.second - a.second }
            pq.addAll(hashMap.map { Pair(it.key, it.value) })

            return buildList {
                for (i in 1..k)
                    add(pq.poll().first)
            }.toTypedArray()
        }
    }
}