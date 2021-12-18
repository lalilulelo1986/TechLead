package techlead

import java.lang.StringBuilder

/*
    like mirror words
 */
fun main() {
    println(getPalindrome("foxfo"))
    println(getPalindrome("foxfoxx"))
    println(getPalindrome("t"))
    println(getPalindrome("to"))
    println(getPalindrome("too"))
    println(getPalindrome(""))
}

fun getPalindrome(str: String): String? {
    val charMap = HashMap<Char, Int>()
    str.forEach {
        charMap[it] = charMap.getOrDefault(it, 0) + 1
    }

    val palindrome = StringBuilder(str.length)
    var valid = false
    var middleChar = ""
    charMap.forEach { (k, u) ->
        if (u.mod(2) == 1 && valid.not()) {
            valid = !valid
            middleChar = k.toString()
        } else if (u.mod(2) == 1 && valid) {
            return null
        }
        repeat(u / 2) {
            palindrome.append(k)
        }
    }

    palindrome.append(middleChar, palindrome.reversed())
    return palindrome.toString()
}

/*
from collections import defaultdict

def find_palindrome(str):
  char_counts = defaultdict(int)

  for c in str:
    char_counts[c] += 1

  pal = ''
  odd_char = ''
  for c, cnt in char_counts.items():
    if cnt % 2 == 0:
      pal += c * (cnt // 2)
    elif odd_char == '':
      odd_char = c
      pal += c * (cnt // 2)
    else:
      return False
  return pal + odd_char + pal[::-1]


print(find_palindrome('foxfo'))
# foxof
 */