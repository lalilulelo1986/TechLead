package techlead

/*
* Дан отсортированный со сдвигом массив (rotated array) чисел, дано число, вернуть    индекс этого числа в массиве. Если такого элемента нет то вернуть -1. Должно работать за O(log N). Пример массива: {5,6,8,12,100, 1,3,4}
* */
fun main() {
    val array = arrayOf(5, 6, 8, 12, 100, 1, 1, 3, 4)
    indexOf(array, 4)
    println(index)
}

var index = -1

fun indexOf(array: Array<Int>, number: Int, begin: Int = 0, end: Int = array.size - 1) {
    if (begin > end)
        return
    val midIndex = (begin + end) / 2
    if (array[midIndex] == number && (midIndex < index || index == -1))
        index = midIndex

    val leftOrdered = array[midIndex] >= array[begin]
    val rightOrdered = array[midIndex] <= array[end]

    if (leftOrdered && number >= array[begin] && number <= array[midIndex]) {
        indexOf(array, number, begin, midIndex - 1)
        return
    }

    if (rightOrdered && number >= array[midIndex] && number <= array[end]) {
        indexOf(array, number, midIndex + 1, end)
        return
    }
    if (leftOrdered.not() && (number >= array[begin] || number <= array[midIndex])) {
        indexOf(array, number, begin, midIndex - 1)
        return
    }
    if (rightOrdered.not() && (number >= array[midIndex] || number <= array[end])) {
        indexOf(array, number, midIndex + 1, end)
        return
    }
}