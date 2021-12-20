package techlead

fun main() {
    val arr = arrayOf(4, 3, 2, 6, 8, 1)
    println(insertSort(arr).toList())
}

// My
fun insertSort(arr: Array<Int>): Array<Int> {
    for (i in 1 until arr.size) {
        val key = arr[i]
        var prev = i - 1
        while (prev >= 0 && key < arr[prev]) {
            arr[prev + 1] = arr[prev]
            prev--
            println(arr.toList())
        }
        if (prev != i - 1)
            arr[prev + 1] = key
    }

    return arr
}