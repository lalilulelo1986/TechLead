package techlead

fun main() {
    val arr = arrayOf(0, 1, 3, 0, 0, 2, 5)
    moveZeros(arr)
    println(arr.toList())
}

fun moveZeros(array: Array<Int>) {
    var zeroPoint = Int.MAX_VALUE
    for (i in array.indices) {
        if (array[i] > 0 && zeroPoint < i) {
            array[zeroPoint] = array[i]
            array[i] = 0
            zeroPoint++
        }
        if (array[i] == 0 && zeroPoint == Int.MAX_VALUE) {
            zeroPoint = i
        }
    }
}