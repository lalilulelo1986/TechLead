package techlead

val magazine = arrayOf('A', 'B', 'C', 'D', 'E', 'F', 'A')

fun main() {
    val canSpell = canSpell2(magazine, "BFCAAA")
    println(canSpell)
}

// Solution 1 BroodForce
fun canSpell(magazine: Array<Char>, word: String): Boolean {
    var charFound = 0
    val visited = Array(magazine.size) { false }
    word.forEach { char ->
        for (i in magazine.indices) {
            if (magazine[i] == char && visited[i].not()) {
                visited[i] = true
                charFound++
            }
        }
    }

    return word.length == charFound
}

// Solution 2 Hash table
fun canSpell2(magazine: Array<Char>, word: String): Boolean {
    val wordsByAmount = HashMap<Char, Int>(magazine.size)
    magazine.forEach {
        wordsByAmount.computeIfAbsent(it) { 0 }
        wordsByAmount.computeIfPresent(it) { _, v -> v + 1 }
    }
    println(wordsByAmount)
    word.forEach {
        val afterDecrement = wordsByAmount.computeIfPresent(it) { _, v -> v - 1 } ?: -1
        if (afterDecrement < 0)
            return false
    }
    return true
}