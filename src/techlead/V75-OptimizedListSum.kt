package techlead

fun main() {
    println(ListSum(listOf(1, 2, 3, 4, 5, 6, 7)).sum(2, 5))
}

// [1, 2, 3, 4, 5, 6, 7]
//  1  3  6  10 15 21 28
class ListSum(list: List<Int>) {
    private val sums = Array(list.size + 1) { 0 }

    init {
        var sum = 0
        for (i in list.indices) {
            sum += list[i]
            sums[i + 1] = sum
        }
    }

    fun sum(first: Int, second: Int): Int {
        if (first >= second || first < 0 || second > sums.size)
            throw IllegalArgumentException("invalid input. first: $first second: $second")
        return sums[second] - sums[first]
    }
}