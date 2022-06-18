package techlead

import kotlin.math.pow

fun main() {
    println(convertToInt("-105"))
}

fun convertToInt(string: String): Double {
    var minus = false
    var result = 0.0
    string.forEach {
        if (it == '-')
            minus = true
        else if (it in '0'..'9') {
            result = result * 10.0 + it.code - '0'.code
        }
    }
    return if (minus) -result else result
}