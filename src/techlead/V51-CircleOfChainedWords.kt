package techlead

import java.util.*
import kotlin.collections.HashMap

//print(chainedWords(['apple', 'eggs', 'snack', 'karat', 'tuna']))
//# True
//
//print(chainedWords(['apple', 'eggs', 'snack', 'karat', 'tunax']))
//# False

fun main() {
    val arr = arrayOf("apple", "eggs", "snack", "karat", "tuna")
    val arr2 = arrayOf("apple", "eggs", "snack", "karat", "tunax")
    val arr3 = arrayOf("apple", "karat", "tuna", "eggs", "snack", "alli", "ibba", "alli", "isdf", "fdsa")
    println(Solution51(arr).townGame())
    println(Solution51(arr2).townGame())
    println(Solution51(arr3).townGame())
}

class Solution51(val array: Array<String>) {
    val startMap = HashMap<Char, MutableList<Int>>()
    val visited = arrayOfNulls<Int>(array.size)
    var isCircle = false

    fun townGame(): Boolean {
        for (i in array.indices) {
            startMap.computeIfPresent(array[i].first()) { _, v -> v.also { it.add(i) } }
            startMap.putIfAbsent(array[i].first(), mutableListOf(i))
        }
        println(startMap)
        helper(array.first())
        return isCircle
    }

    private fun helper(str: String, depth: Int = 0) {
        if (depth == array.size)
            isCircle = true
        startMap[str.last()]?.forEach {
            if (visited[it] == null) {
                visited[it] = 1
                helper(array[it], depth + 1)
                visited[it] = null
            }
        }
    }
}