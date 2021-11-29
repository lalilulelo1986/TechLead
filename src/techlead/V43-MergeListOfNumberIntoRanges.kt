package techlead

// divide array to subArrays without gaps
// aka merging intervals
fun main() {
    var arr = arrayOf(0, 1, 2, 5, 7, 8, 9, 9, 10, 11, 15)
    println(divideToSubs(arr))
}

fun divideToSubs(array: Array<Int>): List<List<Int>> {
    if (array.isEmpty())
        return emptyList()
    val result = mutableListOf<List<Int>>()
    var start = 0
    var prev = array[0]

    for (i in array.indices) {
        if (array[i] - prev > 1) {
            result.add(listOf(array[start], array[i - 1]))
            start = i
            prev = array[i]
        } else {
            prev = array[i]
        }
    }
    result.add(listOf(array[start], array[array.size - 1]))

    return result
}
