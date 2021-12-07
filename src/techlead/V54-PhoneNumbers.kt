package techlead

/*
*   1: [],
    2: ['a', 'b', 'c'],
    3: ['d', 'e', 'f'],
    4: ['g', 'h', 'i'],
    5: ['j', 'k', 'l'],
    6: ['m', 'n', 'o'],
    7: ['p', 'q', 'r', 's'],
    8: ['t', 'u', 'v'],
    9: ['w', 'x', 'y', 'z'],
    0: []
* */
fun main() {
    println(getWordsByNumber("364").toList())
    println(getWordsByNumber("228").toList())
}

// My solution
val lettersMaps = hashMapOf(
    1 to arrayOf(),
    2 to arrayOf("a", "b", "c"),
    3 to arrayOf("d", "e", "f"),
    4 to arrayOf("g", "h", "i"),
    5 to arrayOf("j", "k", "l"),
    6 to arrayOf("m", "n", "o"),
    7 to arrayOf("p", "q", "r", "s"),
    8 to arrayOf("t", "u", "v"),
    9 to arrayOf("w", "x", "y", "z"),
    0 to arrayOf(),
)
var words = listOf("dog", "cat", "fish", "fog")

fun getWordsByNumber(number: String): Array<String> {
    var result = words.filter { it.length == number.length }.toMutableList()

    for (n in number.indices) {
        val letters = lettersMaps[number[n].digitToInt()] ?: emptyArray()
        result = result.filter { it[n].toString() in letters }.toMutableList()
    }

    return result.toTypedArray()
}

// TechLead O(3^n) complexity. broodforce
/*
 ettersMaps = {
    1: [],
    2: ['a', 'b', 'c'],
    3: ['d', 'e', 'f'],
    4: ['g', 'h', 'i'],
    5: ['j', 'k', 'l'],
    6: ['m', 'n', 'o'],
    7: ['p', 'q', 'r', 's'],
    8: ['t', 'u', 'v'],
    9: ['w', 'x', 'y', 'z'],
    0: []
}

validWords = ['dog', 'fish', 'cat', 'fog']


def makeWords_helper(digits, letters):
  print(letters)
  if not digits:
    word = ''.join(letters)
    if word in validWords:
      return [word]
    return []

  results = []
  chars = lettersMaps[digits[0]]
  for char in chars:
    results += makeWords_helper(digits[1:], letters + [char])
  return results


def makeWords(phone):
  digits = []
  for digit in phone:
    digits.append(int(digit))
  return makeWords_helper(digits, [])


print(makeWords('364'))
*/
