package techlead

fun main() {
    /*
    * [1, 2, 3, 4] = [24, 12, 8, 6]
    * */
    println(MySolution.foo(arrayOf(1, 2, 3, 4, 5)))
}
// not best
class MySolution {
    companion object {
        fun foo(array: Array<Int>): List<Int> {
            var summ = 1
            val result = mutableListOf<Int>()
            for (a in array) {
                summ *= a
            }
            for (a in array)
                result.add(summ / a)

            return result
        }
    }
}

// TODO