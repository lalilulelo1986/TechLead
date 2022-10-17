package techlead.noveo

import kotlin.test.assertEquals

fun main() {
    val array1 = arrayOf(4, 5, 6, 7, 0, 1, 2)
    assertEquals(4, search(array1, 0))
    val array2 = arrayOf(4, 5, 6, 7, 0, 1, 2)
    assertEquals(-1, search(array2, 3))
    val array3 = arrayOf(1)
    assertEquals(-1, search(array3, 0))
}

fun search(array: Array<Int>, number: Int, begin: Int = 0, end: Int = array.size - 1): Int {
    if (begin > end)
        return -1
    val midIndex = (begin + end) / 2
    if (array[midIndex] == number)
        return midIndex

    val leftOrdered = array[midIndex] >= array[begin]
    val rightOrdered = array[midIndex] <= array[end]

    if (leftOrdered && number >= array[begin] && number <= array[midIndex]) {
        return search(array, number, begin, midIndex - 1)
    }

    if (rightOrdered && number >= array[midIndex] && number <= array[end]) {
        return search(array, number, midIndex + 1, end)
    }
    if (leftOrdered.not() && (number >= array[begin] || number <= array[midIndex])) {
        return search(array, number, begin, midIndex - 1)
    }
    if (rightOrdered.not() && (number >= array[midIndex] || number <= array[end])) {
        return search(array, number, midIndex + 1, end)
    }
    return -1
}