package techlead

import java.time.Instant
import java.util.*

fun main() {
//    val toIntArray = generateSequence(40_000_001) { it - 1 }.takeWhile { it >= 1 }.toMutableList().toTypedArray()
//        .also {
//            it[2] = -1
//            it.shuffle()
//        }
    val arr = arrayOf(0)

    val start = Instant.now().toEpochMilli()

    println(firstMissingSwap(arr)) // 10
//        println(firstMissingFast(toIntArray)) //  63
//    println(firstMissing(toIntArray)) // 22

    println((Instant.now().toEpochMilli() - start) / 1000)
}

// my time complexity
fun firstMissing(arr: Array<Int>): Int {
    val sorted = arr.sortedArray()
    var missing = 1
    for (el in sorted) {
        if (el <= 0)
            continue
        if (el > missing)
            return missing
        else
            missing++
    }
    return missing
}

// techLead space complexity
fun firstMissingFast(arr: Array<Int>): Int {
    val hash = HashMap<Int, Int>(arr.size)
    for (el in arr)
        hash[el] = 1

    for (missing in 1..arr.size + 1) {
        if (hash[missing] == null)
            return missing
    }

    return -1
}

// swap mutable solution
fun firstMissingSwap(arr: Array<Int>): Int {
    if (arr.size == 1 && arr[0] == 1)
        return 2

    val len = arr.size
    var point = 0
    var tmp: Int
    while (point < len) {
        if (point != arr[point] && arr[point] in 0 until len) {
            tmp = arr[point]
            arr[point] = arr[arr[point]]
            arr[tmp] = tmp
        } else {
            point++
        }
    }

    for (i in 1 until len) {
        if (arr[i] != i)
            return i
    }

    return 1
}