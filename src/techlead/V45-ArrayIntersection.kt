package techlead

fun main() {
    val arr1 = arrayOf(4, 9, 5)
    val arr2 = arrayOf(9, 4, 9, 8, 4)

    println(intersection(arr1, arr2))
    println(intersectionSort(arrayOf("hello", "food"), arrayOf("food", "tee", "meet")))
}

fun <T> intersection(arr1: Array<T>, arr2: Array<T>): List<T> {
    val result = mutableListOf<T>()
    val hashMap = HashMap<T, Boolean>()

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

fun <T: Comparable<T>> intersectionSort(arr1: Array<T>, arr2: Array<T>): List<T> {
    arr1.sort()
    arr2.sort()
    val set = HashSet<T>()
    var p1 = 0
    var p2 = 0

    while (p1 < arr1.size && p2 < arr2.size) {
        if (arr1[p1] == arr2[p2]) {
            set.add(arr1[p1])
            p1++
        } else if (arr1[p1] > arr2[p2]) {
            p2++
        } else {
            p1++
        }
    }

    return set.toList()
}