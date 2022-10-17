package techlead.noveo

fun main() {
    val array = arrayOf(2, 3, 2).toIntArray()
    println(timeRequiredToBuy(array, 2))

    val array2 = arrayOf(5, 1, 1, 1).toIntArray()
    println(timeRequiredToBuy(array2, 0))
}

fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
    var sum = 0
    tickets.forEachIndexed { index, i ->
        if (index <= k) {
            sum += if (i > tickets[k]) tickets[k] else tickets[index]
        } else {
            sum += if (i >= tickets[k]) tickets[k] - 1 else tickets[index]
        }
    }
    return sum
}