package techlead

fun main() {
    // given
    val nums = listOf(17, 7, 2, 45, 72)
    // result 77245217
    println(makeLargestNum(nums))
}

fun makeLargestNum(nums: List<Int>): String {
    return nums.sortedWith { a, b ->
        if (a.toString() + b.toString() > b.toString() + a.toString())
            -1
        else
            1
    }.joinToString()
}