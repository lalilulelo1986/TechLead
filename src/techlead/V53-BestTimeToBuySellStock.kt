package techlead

import kotlin.math.max

// [9, 11, 8, 5, 7, 10] return max = 5 - is between 5 and 10
fun main() {
    val array = arrayOf(9, 11, 8, 5, 7, 10)
    println(maxProfit(array))
    println(maxProfit2(array))
}

// My
fun maxProfit(array: Array<Int>): Int {
    if (array.isEmpty()) return 0
    var start = 0
    var end = 0
    var maxProfit = 0

    while (end < array.size) {
        if (array[end] < array[start]) {
            start = end
        } else {
            maxProfit = max(maxProfit, array[end] - array[start])
        }
        end++
    }

    return maxProfit
}

// TechLead from end to start loop
fun maxProfit2(array: Array<Int>): Int {
    var maxProfit = 0
    var currentMaxPrice = 0

    for (i in array.indices.reversed()) {
        currentMaxPrice = max(currentMaxPrice, array[i])
        maxProfit = max(maxProfit, currentMaxPrice - array[i])
    }

    return maxProfit
}