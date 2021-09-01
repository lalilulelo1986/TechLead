package techlead

import java.util.*

fun main() {
    val input = arrayOf("M", "M", "R", "M", "M", "M", "L", "M", "M", "R", "M")
    val find = Solution15.push(input)
    println(find)
}

// My (cognitive complexity)
class Solution15 {
    companion object {

        fun push(array: Array<String>): List<String> {
            var lastInd: Int? = null
            var lastType: String? = null
            for (i in array.indices) {
                if (array[i] == "L" && lastType == "R") {
                    val mid = (i - lastInd!!) / 2.0 + lastInd
                    for (j in lastInd..i) {
                        println("J: $j mid: ${mid}")
                        if (j < mid) {
                            array[j] = "R"
                            println("ind: $j: ${array[j]}")
                        }
                        if (j > mid)
                            array[j] = "L"
                    }
                } else if (array[i] == "L") {
                    for (j in (lastInd ?: 0)..i) {
                        array[j] = "L"
                    }
                } else if (array[i] == "R" && lastType == "R") {
                    for (j in lastInd!!..i) {
                        array[j] = "R"
                    }
                }

                if (array[i] != "M") {
                    lastInd = i
                    lastType = array[i]
                }
            }
            if (lastType == "R")
                for (j in lastInd!! until array.size) {
                    array[j] = "R"
                }
            return array.toList()
        }
    }
}