package techlead.noveo

import kotlin.test.assertEquals

fun main() {
    val nums = arrayOf(-1, 0, 3, 5, 9, 12).toIntArray()
    assertEquals(4, search(nums, 9))

    val nums2 = arrayOf(-1, 0, 3, 5, 9, 12).toIntArray()
    assertEquals(-1, search(nums, 2))
}

fun search(nums: IntArray, target: Int, begin: Int = 0, end: Int = nums.size): Int {
    if (begin > end)
        return -1

    val mid = (begin + end) / 2
    return if (nums[mid] == target)
        mid
    else if (nums[mid] > target) {
        search(nums, target, begin, mid - 1)
    } else {
        search(nums, target, mid + 1, end)
    }
}