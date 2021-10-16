package techlead

fun main() {
    val uniqueVals = arrayOf(-1, 0, 1, 2, -4, -3)
    println(
        sumThree(uniqueVals.sortedArray(), 0)
        )
    // -4, -3, -1, 0, 1, 2
}

// My. but u can sort array and put start and end pointers and move them to each other to fins sum of 2
fun sumThree(arr: Array<Int>, sum: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    for (i in 0..arr.size - 3) {
        val sumOfTwo = sumOfTwo(arr, sum - arr[i], i + 1)
        if (sumOfTwo.isNotEmpty()) {
            sumOfTwo.forEach {
                result.add(listOf(arr[i], it.key, it.value))
            }
        }
    }
    return result
}

fun sumOfTwo(arr: Array<Int>, sum: Int, inx: Int): HashMap<Int, Int> {
    val hashHolder = HashMap<Int, Int>()
    val res = HashMap<Int, Int>()
    for (i in inx until arr.size) {
        if (arr[i] > sum)
            break
        if (hashHolder[sum - arr[i]] == null) {
            hashHolder[arr[i]] = arr[i]
        } else {
            res[arr[i]] = sum - arr[i]
        }
    }

    return res
}