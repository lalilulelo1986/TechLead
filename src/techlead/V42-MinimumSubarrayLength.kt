package techlead

import java.time.Instant
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

// find min sub array which results to K sum or more
fun main() {
    val arr = arrayOf(2, 3, 1, 2, 4, 3)

    var start = Instant.now().toEpochMilli()
    println(findMinSub(arr, 7))
    println("time: " + (Instant.now().toEpochMilli() - start) / 1000)
}

// My. not just int but array itself
fun findMinSub(array: Array<Int>, k: Int): List<Int> {
    var maxLength = 0
    var sum = 0
    var subStart = -1
    var start = -1
    var end = -1

    while (start < array.size - 1) {
        if (sum < k && end < array.size - 1) {
            end++
            sum += array[end]
        } else {
            start++
            sum -= array[start]
        }
        if (sum >= k && (end - start < maxLength || maxLength == 0)) {
            subStart = start + 1
            maxLength = end - start
        }
    }

    return array.slice(IntRange(subStart, subStart + maxLength - 1))
}