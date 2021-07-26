package techlead.common

fun main() {
    println(factorial(4))
}

public fun factorial(number: Long): Long {
    if (number == 1L)
        return 1L
    return number * factorial(number - 1)
}