package techlead

import java.util.*

fun main() {
    val nums = listOf(900, 100, 200, 300)
    val sum = 500
    println(findSubSum2(nums, sum))
}

fun findSubSum2(nums: List<Int>, sum: Int): List<Int>? {
    val subset = TreeMap<Int, MutableList<Int>>()

    for (num in nums.sortedDescending()) {
        if (num == sum)
            return listOf(num)
        if (num <= sum) {
            val keys = subset.keys.toList()
            keys.forEach { key ->
                if (key + num == sum)
                    return subset[key]!!.plus(mutableListOf(num))
                if (key + num <= sum) {
                    subset.putIfAbsent(key + num, subset[key]!!.plus(mutableListOf(num)).toMutableList())
                }
            }
            subset.putIfAbsent(num, mutableListOf(num))
        }
    }

    return subset[sum]?.toList()
}