package techlead

import kotlin.math.ceil

fun main() {
    val buildQueens = buildQueens(5)
    buildQueens.forEach { x ->
        x.forEach { y ->
            print("$y  ")
        }
        println()
    }
}

// First
fun buildQueens(n: Int): Array<Array<Int>> {
    val result = Array(n) { Array(n) { 0 } }
    populateQueens(result)
    populateQueens(result, ceil((result.size) / 2.0).toInt() - 2, result.size - 1 - 1)

    return result
}

fun populateQueens(array: Array<Array<Int>>, x: Int = array.size - 1, y: Int = array.size - 1) {
    if (x >= 0 && x <= array.size - 1 && y >= 0 && y <= array.size - 1) {
        array[x][y] = 1
        populateQueens(array, x - 1, y - 2)
    }
}

// Similar to Tech
fun buildQueens2(n: Int): Array<Array<Int>> {
    val result = Array(n) { Array(n) { 0 } }
    val horiHolder = Array(2 * n + 1) { "VHUD" }
    val vertHolder = Array(2 * n + 1) { "" }

    return result
}

fun populateQueens2(array: Array<Array<Int>>, x1: Int, y1: Int, x2: Int, y2: Int) {

}