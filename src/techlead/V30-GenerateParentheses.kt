package techlead

fun main() {
    println(genParentheses(3))
}

// Tech Lead
// TODO cool think
fun genParentheses(size: Int, left: Int = 0, right: Int = 0, str: String = ""): List<String> {
    if (left + right == 2 * size)
        return listOf(str)

    val result = mutableListOf<String>()
    if (left < size)
        result.addAll(genParentheses(size, left + 1, right, "$str("))
    if (right < left)
        result.addAll(genParentheses(size, left, right + 1, "$str)"))

    return result
}