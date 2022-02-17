package techlead

import java.util.*

fun main() {
    val array = arrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
    val array2 = arrayOf("F", "D", "A")
    quickSortDfs(array, false)
    println(array.toList())
}

fun quickSort(array: Array<Int>, start: Int = 0, end: Int = array.size - 1) {
    if (end - start <= 0)
        return

    val pivot = array[end]
    var pointer = start
    for (i in start until end) {
        if (array[i] < pivot) {
            swap(array, pointer, i)
            pointer++
        }
    }
    swap(array, pointer, end)
    quickSort(array, start, pointer - 1)
    quickSort(array, pointer + 1, end)
}

fun <T: Comparable<T>> quickSortDfs(array: Array<T>, desc: Boolean = false) {
    val stack = Stack<Pair<Int, Int>>()
    stack.push(0 to array.size - 1)
    while (stack.isNotEmpty()) {
        val popped = stack.pop()
        if (popped.second - popped.first <= 0)
            continue

        val pivot = array[popped.second]
        var pointer = popped.first
        for (i in popped.first until popped.second) {
            if ((array[i] < pivot).xor(desc)) {
                swap(array, pointer, i)
                pointer++
            }
        }
        swap(array, pointer, popped.second)
        stack.push(popped.first to pointer - 1)
        stack.push(pointer + 1 to popped.second)
    }
}

fun <T: Comparable<T>> swap(array: Array<T>, first: Int, second: Int) {
    if (first != second) {
        val tmp = array[first]
        array[first] = array[second]
        array[second] = tmp
    }
}