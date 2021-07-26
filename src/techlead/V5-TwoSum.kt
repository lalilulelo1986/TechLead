package techlead

/*
* given -> [2, 7, 11, 18], target = 18
* find two numbers witch will give you target when you sum them
* */

fun main() {
    println(sumTwo2(arrayOf(2, 7, 11, 15), 18).asList())
}

// Solution one like fibo complexity
fun sumTwo(array: Array<Int>, target: Int): Array<Int> {
    for (i in 0..array.size - 2) {
        for (j in i + 1 until array.size) {
            if (array[i] + array[j] == target)
                return arrayOf(array[i], array[j])
        }
    }
    return emptyArray()
}

// Solution with HashMap
fun sumTwo2(array: Array<Int>, target: Int): Array<Int> {
    val hashHolder = HashMap<Int, Int>(array.size)
    for (i in array.indices)
        hashHolder[target - array[i]]?.let { second ->
            return arrayOf(array[second], array[i])
        } ?: run { hashHolder[array[i]] = i }
    return arrayOf()
}