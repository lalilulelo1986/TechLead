package techlead

fun main() {
    val array = arrayOf(10, 9, 2, 5, 3, 7, 101, 18).toIntArray()
    println("result: ${longestIncSub(array)}")
}

fun longestIncSub(nums: IntArray): Int {
    val lens = Array(nums.size) { 1 }
    for (i in 1 until nums.size)
        for (k in 0 until i)
            if (nums[i] > nums[k])
                lens[i] = maxOf<Int>(lens[i], lens[k] + 1)
    return lens.maxOrNull() ?: 0
}