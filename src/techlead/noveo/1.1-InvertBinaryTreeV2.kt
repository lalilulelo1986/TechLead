package techlead.noveo

import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.test.assertEquals

fun main() {
    val root = arrayOf(4, 2, 7, 1, 3, 6, 9)
    invertTree(root)
    assertEquals("4,7,2,9,6,3,1", root.joinToString(","))
}

fun invertTree(array: Array<Int>) {
    for (i in 0..sqrt(array.size.toDouble()).toInt()) {
        val start = (2.0.pow(i.toDouble()) - 1).toInt()
        invertSegment(array, start, start * 2)
    }
}

fun invertSegment(array: Array<Int>, beg: Int, end: Int) {
    if (end > beg) {
        // swap begin with end
        array[beg] = array[end].also { array[end] = array[beg] }
        invertSegment(array, beg + 1, end - 1)
    }
}