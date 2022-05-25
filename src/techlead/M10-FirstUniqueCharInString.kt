package techlead

fun main() {
    val str = "aldkfjhweyrpqziwhflaksjvdhapiesryq"
    println(firstUniqueChar(str))
    println(firstUniqueChar2(str))
}

// with eng only
fun firstUniqueChar(string: String): Char? {
    val counts = MutableList(26) { 0 }
    string.forEach {
        counts[it - 'a']++
    }
    string.forEach {
        if (counts[it - 'a'] == 1)
            return it
    }
    return null
}

// linked hashMap
fun firstUniqueChar2(string: String): Char? {
    val linkedMap = LinkedHashMap<Char, Int>()
    string.forEach {
        linkedMap.computeIfPresent(it) { _, v -> v + 1 } ?: run { linkedMap[it] = 1 }
    }
    linkedMap.forEach {
        if (it.value == 1)
            return it.key
    }
    return null
}