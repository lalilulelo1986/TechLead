package techlead

import kotlin.math.max
import kotlin.math.min

// max subArray by sum elements
fun main() {
    val arr = arrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4) // return 6
    println(getMaxSubArray(arr))
    println(getMaxSubArray2(arr))
}

fun getMaxSubArray(array: Array<Int>): Int? {
    if (array.isEmpty())
        return null
    var max = 0
    var min = 0

    val sums = Array(array.size) { 0 }
    var sum = 0
    array.forEachIndexed { index, i ->
        sum += i
        sums[index] = sum
        max = max(max, sum)
    }
    for (v in sums) {
        if (v == max) {
            break
        }
        min = min(min, v)
    }

    return max - min
}

// tech
fun getMaxSubArray2(array: Array<Int>): Int {
    var maxSum = 0
    var sum = 0
    array.forEach {
        sum += it
        if (sum < 0)
            sum = 0
        else
            maxSum = max(maxSum, sum)
    }
    return maxSum
}