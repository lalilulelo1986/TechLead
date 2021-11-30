package techlead

fun main() {
    val arr1 = arrayOf(4, 9, 5)
    val arr2 = arrayOf(9, 4, 9, 8, 4)

    println(intersection(arr1, arr2))
}

fun intersection(arr1: Array<Int>, arr2: Array<Int>): List<Int> {
    val result = mutableListOf<Int>()
    val hashMap = HashMap<Int, Boolean>()

    arr1.forEach {
        hashMap[it] = false
    }
    arr2.forEach {
        if (hashMap[it] == false) {
            result.add(it)
            hashMap[it] = true
        }
    }

    return result
}