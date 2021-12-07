package techlead

fun main() {
    val arr = arrayOf(4, 3, 5, 2, 0, 1)
    println(quickSelect(arr, 3))
    val arr2 = arrayOf(8, 7, 2, 3, 4, 1, 5, 6, 9, 0)
    println(quickSelect(arr2, 3))
}

fun quickSelect(array: Array<Int>, k: Int): Int {
    var partStart = 0
    var partEnd = array.size - 1
    var pivot = 0
    var p1 = 0
    var p2 = 0
    var tmp: Int

    while (partStart != partEnd) {
        while (p2 <= partEnd) {
            if (array[p2] < array[pivot]) {
                p1++
                if (p2 > p1) {
                    tmp = array[p1]
                    array[p1] = array[p2]
                    array[p2] = tmp
                }
            }
            p2++
        }
        println("partStart: $partStart, partEnd: $partEnd, p1: $p1, p2: $p2, pivot: $pivot")
        tmp = array[pivot]
        array[pivot] = array[p1]
        array[p1] = tmp

        if (p1 == k - 1) {
            return array[p1]
        } else if (p1 > k - 1) { // go to left partition
            partEnd = p1 - 1
            pivot = partStart
            p1 = partStart
            p2 = partStart
        } else { // go to right partition
            partStart = ++p1
            pivot = p1
            p2 = p1
        }
        if (partStart == partEnd)
            return array[p1]
        println(array.toList())
    }

    return 0
}