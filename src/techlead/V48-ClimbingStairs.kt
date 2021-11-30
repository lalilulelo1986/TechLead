package techlead

//
fun main() {
    val stairs = 5
    println(fibo(5))
    println(fibo2(5))
}

fun fibo(number: Int): Int {
    if (number <= 1)
        return 1
    if (number == 2)
        return 2
    return fibo(number - 1) + fibo(number - 2)
}

fun fibo2(number: Int): Int {
    var result = 0
    var prev = 1

    for (i in 0..number) {
        if (i <= 1) {
            result = 1
        } else {
            result += prev
            prev = result - prev
        }
    }

    return result
}