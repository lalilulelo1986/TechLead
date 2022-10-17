package techlead.noveo

import techlead.common.Node
import kotlin.test.assertEquals

fun main() {
    val array = arrayOf(-10, -3, 0, 5, 9).toIntArray()
    val res1 = sortedArrayToBST(array)

    assertEquals(0, res1!!.value)
    assertEquals(-10, res1!!.left!!.value)
    assertEquals(-3, res1!!.left!!.right!!.value)
    assertEquals(5, res1!!.right!!.value)
    assertEquals(9, res1!!.right!!.right!!.value)
}

fun sortedArrayToBST(nums: IntArray): Node<Int>? {
    return helperSortedArrayToBST(nums, 0, nums.size - 1)
}

fun helperSortedArrayToBST(nums: IntArray, beg: Int, end: Int): Node<Int>? {
    if (beg > end)
        return null
    val mid = (beg + end) / 2
    val node = Node(nums[mid])
    node.left = helperSortedArrayToBST(nums, beg, mid - 1)
    node.right = helperSortedArrayToBST(nums, mid + 1, end)
    return node
}
