package techlead

fun main() {
    val sortedArray = arrayOf(1, 3, 5, 5, 7, 8, 9, 9, 15)

    println(Solution().findFirstAndLast(sortedArray, 5, 0, sortedArray.size - 1).toList())
}

class Solution {
    var firstEl = -1
    var lastEl = -1

    // binary search
    fun findFirstAndLast(arr: Array<Int>, target: Int, first: Int, last: Int): Array<Int> {
        val mid = (last + first) / 2
        println("mid: $mid first: $first last: $last")
        if (arr[mid] == target) {
            if (firstEl > mid || firstEl == -1)
                firstEl = mid
            if (lastEl < mid || lastEl == -1)
                lastEl = mid
            if (mid - 1 >= first)
                findFirstAndLast(arr, target, first, mid - 1)
            if (mid + 1 <= last)
                findFirstAndLast(arr, target, mid + 1, last)
        } else if (arr[mid] > target) {
            if (mid - 1 >= first)
                findFirstAndLast(arr, target, first, mid - 1)
        } else {
            if (mid + 1 <= last)
                findFirstAndLast(arr, target, mid + 1, last)
        }
        return if (firstEl != -1 || lastEl != -1) arrayOf(firstEl, lastEl) else arrayOf()
    }
}