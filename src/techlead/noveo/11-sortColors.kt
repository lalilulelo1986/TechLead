package techlead.noveo

import kotlin.test.assertEquals

fun main() {
    val nums = arrayOf(2, 0, 2, 1, 1, 0).toIntArray()
    bucketSort(nums)
    assertEquals(listOf(0, 0, 1, 1, 2, 2).joinToString(), nums.joinToString())

    val nums2 = arrayOf(2, 0, 2).toIntArray()
    bucketSort(nums2)
    assertEquals(listOf(0, 2, 2).joinToString(), nums2.joinToString())

    val x = 3
    when {
        x > 1 -> println(x)
        x > 2 -> println(x)
        else -> println(x)
    }
}

fun bucketSort(nums: IntArray) {
    val array = arrayOf(0, 0, 0)
    nums.forEach {
        array[it] = array[it] + 1
    }
    var counter = 0
    array.forEachIndexed { index, i ->
        for (i2 in 0 until i) {
            nums[counter] = index
            counter++
        }
    }
}