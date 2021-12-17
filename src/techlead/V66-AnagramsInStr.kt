package techlead

/*
    print(find_anagrams('acdbacdacb', 'abc'))
    # [3, 7]
 */
fun main() {
    println(findAnagrams("acdbacdacb", "abc").toList())
}

fun findAnagrams(src: String, target: String): Array<Int> {
    val occurrence = HashMap<Char, Int>()
    target.forEach {
        occurrence[it] = occurrence.getOrDefault(it, 0) + 1
    }

    val result = mutableListOf<Int>()
    var matchCounter = 0
    src.forEachIndexed { i, c ->
        occurrence.computeIfPresent(c) { _, v ->
            if (v == 1)
                matchCounter++
            else if (v == 0)
                matchCounter--
            v - 1
        }

        if (i >= target.length)
            occurrence.computeIfPresent(src[i - target.length]) { _, v ->
                if (v == -1)
                    matchCounter++
                else if (v == 0)
                    matchCounter--
                v + 1
            }

        if (matchCounter == occurrence.size)
            result.add(i - target.length + 1)
    }

    return result.toTypedArray()
}

/*

from collections import defaultdict

def find_anagrams(a, b):
  char_map = defaultdict(int)

  for c in b:
    char_map[c] += 1

  results = []
  for i in range(len(a)):
    c = a[i]

    if i >= len(b):
      c_old = a[i - len(b)]
      char_map[c_old] += 1
      if char_map[c_old] == 0:
        del char_map[c_old]

    char_map[c] -= 1
    if char_map[c] == 0:
      del char_map[c]

    if i + 1 >= len(b) and len(char_map) == 0:
      results.append(i - len(b) + 1)

  return results


print(find_anagrams('acdbacdacb', 'abc'))
# [3, 7]

 */