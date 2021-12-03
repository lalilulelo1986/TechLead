package techlead

import kotlin.math.max

// AABCBBEACC - RETURN 4
fun main() {
    val str = "AABCBBEACC"
    println(nonRepeatingSubstring(str))
    println(slidingWindow(str))
}

// My
fun nonRepeatingSubstring(str: String): Int {
    var maxLen = 0
    var curLen = 0
    val hashMap = HashMap<Char, Int>(str.length)
    for (char in str) {
        if (hashMap[char] == null) {
            curLen++
        } else {
            hashMap.clear()
            curLen = 1
        }
        hashMap[char] = 1
        maxLen = max(maxLen, curLen)
    }
    return maxLen
}

// TechLead
fun slidingWindow(str: String): Int {
    var maxLen = 0
    var start = -1
    var end = -1
    val lastPlace = HashMap<Char, Int>()

    for (ind in str.indices) {
        end++
        if (lastPlace[str[ind]] != null)
            start = max(lastPlace[str[ind]]!!, start)

        maxLen = max(maxLen, end - start)
        lastPlace[str[ind]] = ind
    }

    return maxLen
}