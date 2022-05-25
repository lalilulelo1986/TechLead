package techlead

/*
    * - Matches zero or more of the preceding element
    . - Matches any single character
    aa -> a = false
    ab, a* = true
    aba, a*a = true
    aab, *b = true
 */

fun main() {
    println(MyPattern("c*a*b").match("aab"))
}

class MyPattern(private val pattern: String) {

    private var isMatch = false

    fun match(str: String): Boolean {
        isMatch = false
        validate(str.toCharArray(), 0, pattern.toCharArray(), 0)
        return isMatch
    }

    fun validate(
        str: CharArray,
        s: Int,
        pattern: CharArray = this.pattern.toCharArray(),
        p: Int = 0,
        starBefore: Boolean = false
    ) {
//        println("pattern.size: ${pattern.size} p: $p str.size: ${str.size} s: $s")
        if (isMatch || p == pattern.size && starBefore || p == pattern.size && s == str.size) {
            isMatch = true
            return
        }
        if (p == pattern.size || s == str.size) {
//            println("return p: $p s: $s")
            return
        }

        if (pattern[p] == '*') {
            validate(str, s, pattern, p + 1,  true)
        } else if (pattern[p] == '.') {
            if (starBefore) {
                for (i in s until str.size) {
                    validate(str, i + 1, pattern, p + 1,  false)
                }
            } else {
                validate(str, s + 1,pattern, p + 1,  false)
            }
        } else {
            if (starBefore) {
                for (i in s until str.size) {
                    if (str[s] == pattern[p])
                        validate(str, i + 1,pattern, p + 1,  false)
                }
            } else {
                if (pattern[p] == str[s])
                    validate(str, s + 1, pattern, p + 1,  false)
            }
        }
    }
}