package techlead

fun main() {
    val longestPalindrome = `M5-LongestPalindromicSubstring`().longestPalindrome("cbbd")
    println(longestPalindrome)
}

class `M5-LongestPalindromicSubstring` {
    fun longestPalindrome(s: String): String {
        val pair = longest1(s.toCharArray(), 0, s.length - 1)
        return s.substring(pair.first, pair.second + 1)
    }

    // shit
    fun longest(str: CharArray, p1: Int, p2: Int): Pair<Int, Int> {
        if (p1 == p2)
            return p1 to p2 - p1 + 1
        val pair1 = longest(str, p1 + 1, p2)
        val pair2 = longest(str, p1, p2 - 1)

        var locP1 = p1
        var locP2 = p2
        var isPalindromic = true
        while (locP1 < locP2) {
            if (str[locP1] != str[locP2]) {
                isPalindromic = false
                break
            }
            locP1++
            locP2--
        }

        val locPair = if (isPalindromic) p1 to p2 - p1 + 1 else p1 to 1

        if (pair1.second >= pair2.second && pair1.second >= locPair.second) {
            return pair1
        } else if (pair2.second >= pair1.second && pair2.second >= locPair.second) {
            return pair2
        } else {
            return locPair
        }
    }

    fun longest1(str: CharArray, p1: Int, p2: Int): Pair<Int, Int> {
        if (str.size == 1)
            return 0 to 0
        var start = 0
        var end = 0
        var maxPalindromic = 0
        for (i in str.indices) {
            for (i2 in i + 1 until str.size) {
                val palindromic = isPalindromic(str, i, i2)
                if (palindromic) {
                    println("i: $i i2: $i2")
                    println()
                    if (i2 - i > maxPalindromic) {
                        maxPalindromic = i2 - i
                        start = i
                        end = i2
                    }
                }
            }
        }
        return start to end
    }

    fun isPalindromic(str: CharArray, start: Int, end: Int): Boolean {
        var locStart = start
        var locEnd = end
        var isPalindromic = true
        while (locStart < locEnd) {
            if (str[locStart] != str[locEnd]) {
                isPalindromic = false
                break
            }
            locStart++
            locEnd--
        }
        return isPalindromic
    }
}