package techlead

fun main() {
//    println(shortestPalindrom("abcbabcaba"))
    println(shortestPalindrom("abcbba"))
}

fun shortestPalindrom(s: String): String {
    val n = s.length
    var i = 0
    for (j in n - 1 downTo 0) {
        if (s[i] == s[j])
            i++
    }
    if (i == n)
        return s
    val remainRev = s.substring(i, n).reversed()
    println("$remainRev + shortestPalindrom(${s.substring(0, i)}) + ${s.substring(i)}")
    return remainRev + shortestPalindrom(s.substring(0, i)) + s.substring(i)
}