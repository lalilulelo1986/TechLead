package techlead

fun main() {
    val arr = arrayOf(4, 1, 2)
    val arr2 = arrayOf(3, 2, 4, 1)
    val arr3 = arrayOf(1, 5, 3, 4, 7)
    val arr4 = arrayOf(2, 3, 1, 2)
    val arr5 = arrayOf(4, 2, 2, 5)
//    println(MySolution18.nonDecrArr(arr))
//    println(MySolution18.nonDecrArr(arr2))
//    println(MySolution18.nonDecrArr(arr3))
//    println(MySolution18.nonDecrArr(arr4))
//    println(MySolution18.nonDecrArr(arr5))

    println(TechSolution.nonDecrArr(arr))
    println(TechSolution.nonDecrArr(arr2))
    println(TechSolution.nonDecrArr(arr3))
    println(TechSolution.nonDecrArr(arr4))
    println(TechSolution.nonDecrArr(arr5))
}

class MySolution18 {
    companion object {
        fun nonDecrArr(array: Array<Int>): Boolean {
            var prev = Int.MIN_VALUE
            var fixed = false
            for (i in array.indices) {
                if (i == array.size - 1)
                    return true
                if (fixed && prev > array[i + 1]) {
                    return false
                }
                if (prev > array[i + 1]) {
                    fixed = true
                    prev = array[i]
                    continue
                }
                if (array[i] < prev) {
                    array[i] = prev
                    fixed = true
                    continue
                }
                if (array[i] > array[i + 1]) {
                    array[i] = array[i + 1]
                    prev = array[i]
                    fixed = true
                    continue
                }
                prev = array[i]
            }
            return true
        }
    }
}

class TechSolution {
    companion object {
        fun nonDecrArr(array: Array<Int>): Boolean {
            var badIndex = -1
            for (i in array.indices) {
                if (i < array.size - 1 && array[i] > array[i + 1]) {
                    if (badIndex != -1)
                        return false
                    badIndex = i
                }
            }

            if (badIndex == 0 || badIndex == array.size - 1)
                return true
            if (array[badIndex - 1] > array[badIndex + 1])
                return false
            return true
        }
    }
}