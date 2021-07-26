package techlead

fun main() {
    val array = arrayOf(4, 3, 2, 4, 1, 3, 2)
    println("Result: ${FindNonDuplicateNumber2().find_non_duplicate_number(array)}")
}

// HashMap
class FindNonDuplicateNumber {

}

// XOR
class FindNonDuplicateNumber2 {
    fun find_non_duplicate_number(array: Array<Int>): Int {
        var result = 0
        array.forEach {
            result = result xor it
        }
        return result
    }
}