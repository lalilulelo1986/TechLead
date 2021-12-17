package techlead

/*

M CM IV = 1000 900 4 = 1904
 */
val romansNumbers = hashMapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000,
)

fun main() {
    println(convertToArab("MCMIV"))
    println(convertToArab2("MCMIV"))
}

// My
fun convertToArab(number: String): Int {
    var result = 0
    var prev = 0
    number.forEach {
        val curr = romansNumbers[it] ?: error("no such letter: $it")
        result += curr
        if (curr > prev) {
            result -= 2 * prev
        }
        prev = curr
    }
    return result
}

// TechLead - reverse solution
fun convertToArab2(number: String): Int {
    var result = 0
    var prev = 0
    number.reversed().forEach {
        val curr = romansNumbers[it] ?: error("no such letter: $it")
        if (prev > curr)
            result -= curr
        else
            result += curr
        prev = curr
    }
    return result
}