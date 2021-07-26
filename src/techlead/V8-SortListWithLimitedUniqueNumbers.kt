package techlead

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val uniqueNumbers = 3
    val arrayWithThreeUniqueNumbers = arrayOf(3, 3, 2, 1, 3, 2, 1)

    val sort = Solution1().sort(arrayWithThreeUniqueNumbers)
    println(sort)
}

class Solution1 {
    val hashTable = HashMap<Int, Int>()
    var first: Int? = null
    var second: Int? = null
    var third: Int? = null

    fun sort(array: Array<Int>): List<Int> {
        for (i in array.indices) {
            hashTable.computeIfPresent(array[i]) { _, v -> v + 1 }
            hashTable.putIfAbsent(array[i], 1)

            if (first == null) {
                first = array[i]
            } else if (second == null && array[i] != first) {
                second = array[i]
            } else if (third == null && array[i] != first && array[i] != second) {
                third = array[i]
            }
        }

        if (first!! > second!!) first = second.also { second = first }
        if (second!! > third!!) second = third.also { third = second }
        if (first!! > second!!) first = second.also { second = first }

        return List(hashTable[first]!!) { first!! } +
            List(hashTable[second]!!) { second!! } +
            List(hashTable[third]!!) { third!! }
    }
}

//def sortNums2(nums):
//one_index = 0
//three_index = len(nums) - 1
//index = 0
//while index <= three_index:
//if nums[index] == 1:
//nums[index], nums[one_index] = nums[one_index], nums[index]
//one_index += 1
//index += 1
//elif nums[index] == 2:
//index += 1
//elif nums[index] == 3:
//nums[index], nums[three_index] = nums[three_index], nums[index]
//three_index -= 1
//return nums
