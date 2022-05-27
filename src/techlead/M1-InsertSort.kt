package techlead

fun main() {
    val arr = arrayOf(4, 3, 2, 6, 8, 1, 1)
    insertSort(arr)
    println(arr.toList())
}

// My. works like you sort card deck
fun insertSort(arr: Array<Int>) {
    for (i in 1 until arr.size) {
        val key = arr[i]
        var prev = i - 1
        while (prev >= 0 && key < arr[prev]) {
            arr[prev + 1] = arr[prev]
            prev--
        }
        if (prev != i - 1)
            arr[prev + 1] = key
    }
}