package techlead

import kotlin.math.sqrt

fun main() {
    val arr = arrayOf(3, 5, 12, 5, 13)
    println(Solution14.find(arr).toList())
}

// My Solution -> Sum of Two
class Solution14 {
    companion object {

        fun find(arr: Array<Int>): Array<Int> {
            val result = mutableListOf<Int>()

            for (i in arr) {
                val summ = i * i
                val hashMap = HashMap<Int, Int>(arr.size)
                for (j in arr) {
                    val diff = summ - j * j
                    if (hashMap.containsKey(diff)) {
                        result.addAll(arrayOf(summ, j * j, diff))
                    } else {
                        hashMap[j * j] = j * j
                    }
                }
            }

            return result.toTypedArray()
        }
    }
}

//def findPythagoreanTriplets(nums):
//for a in nums:
//for b in nums:
//for c in nums:
//if a*a + b*b == c*c:
//return True
//return False
//
//def findPythagoreanTriplets2(nums):
//squares = set([n*n for n in nums])
//
//for a in nums:
//for b in nums:
//if a * a + b * b in squares:
//return True
//return False
//
//print(findPythagoreanTriplets2([3, 5, 12, 5, 13]))
//# True