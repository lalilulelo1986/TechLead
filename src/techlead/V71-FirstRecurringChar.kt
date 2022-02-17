package techlead

// дубликат
fun main() {
    assert(firstRecurChar("qwertty") == 't')
    println(firstRecurChar("qwertty"))
    assert(firstRecurChar("qwerty") == null)
    println(firstRecurChar("qwerty"))
}

//
fun firstRecurChar(str: String): Char? {
    val seen = HashSet<Char>()
    str.forEach {
        if (it in seen)
            return it
        seen.add(it)
    }
    return null
}