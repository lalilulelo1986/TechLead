package techlead

fun main() {
    println(fibonacci(10))
}

fun fibonacci(number: Int): Int {
    var result = 0
    var prev = 0
    for (it in 1..number)
        if (it == 1) {
            result++
        } else {
            result += prev
            prev = result - prev
        }
    return result
}