package techlead

fun main() {
    val array = arrayOf(1, 1, 2, 5, 7, 2)
    println(subArrWithSum(array, 14).toList())
    println(subArrWithSum2(array, 14).toList())
    println(subArrWithSum3(array, 14).toList())
}

// My with increment solution
fun subArrWithSum(array: Array<Int>, target: Int): Array<Int> {
    val incArr = Array(array.size) { 0 }
    var sum = 0
    for (i in array.indices) {
        incArr[i] = array[i] + sum
        sum = incArr[i]
    }
    var start = 0
    var end = 0
    while (end < incArr.size) {
        if (incArr[end] == target)
            return array.copyOfRange(0, end + 1)
        val diff = incArr[end] - incArr[start]
        if (diff == target)
            return array.copyOfRange(start + 1, end + 1)
        if (diff < target)
            end++
        else
            start++
    }
    return emptyArray()
}

// My pointers
fun subArrWithSum2(array: Array<Int>, target: Int): Array<Int> {
    var start = 0
    var end = 0
    var sum = array[0]
    while (start < array.size && end < array.size) {
        if (sum == target)
            return array.copyOfRange(start, end + 1)
        if (sum < target) {
            end++
            sum += array[end]
        } else {
            sum -= array[start]
            start++
        }
    }
    return emptyArray()
}

// TechLead using hashMap as history of sums
fun subArrWithSum3(array: Array<Int>, target: Int): Array<Int> {
    val previosSums = hashMapOf(0 to -1)
    var sum = 0
    array.forEachIndexed { index, n ->
        sum += n
        previosSums[sum] = index
        if (previosSums[sum - target] != null)
            return array.copyOfRange(previosSums[sum - target]!! + 1, index + 1)
    }
    return emptyArray()
}