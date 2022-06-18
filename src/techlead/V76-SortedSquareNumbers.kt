package techlead

import kotlin.math.abs

// return sorted square numbers
fun main() {
    // sorted
    val arr = arrayOf(-5, -3, -1, 0, 1, 4, 5)
    println(squareSorted(arr).toList())
    val arr2 = arrayOf(-9,-8, -5, -3, -1)
    println(squareSorted(arr2).toList())
}

fun squareSorted(array: Array<Int>): Array<Int> {
    val result = Array(array.size) { 0 }
    var begin = 0
    var end = array.size - 1
    var counter = array.size - 1
    while (end >= begin) {
        if (abs(array[begin]) > abs(array[end])) {
            result[counter] = array[begin] * array[begin]
            begin++
        } else {
            result[counter] = array[end] * array[end]
            end--
        }
        counter--
    }
    return result
}

//def square_numbers(nums):
//  neg_i = -1
//  i = 0
//
//  result = []
//  for n in nums:
//      if n >= 0:
//          if neg_i == -1:
//              neg_i = i - 1
//
//          while neg_i >= 0 and nums[neg_i] < 0 and -nums[neg_i] < nums[i]:
//              val = nums[neg_i]
//              result.append(val * val)
//              neg_i -= 1
//
//          val = nums[i]
//          result.append(val * val)
//      i += 1
//
//  while neg_i >= 0 and nums[neg_i] < 0:
//      val = nums[neg_i]
//      result.append(val * val)
//      neg_i -= 1
//
//return result
//
//
//print(square_numbers([-5, -3, -1, 0, 1, 4, 5]))