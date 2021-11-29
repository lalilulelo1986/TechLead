package techlead

import java.util.concurrent.ConcurrentHashMap

/*
    abc
    bcd
    cba
    cbd
    efg
    ['abc', 'bcd', 'cba', 'cbd', 'efg']

    result [(abc, cba), (bcd, cbd), (efg)]
 */
fun main() {
    val words = arrayOf("abc", "bcd", "cba", "cbd", "efg", "abba", "baab")
    println(groupAnagrams(words))
}

fun groupAnagrams(words: Array<String>): List<List<String>> {
    val anagramMap = ConcurrentHashMap<Int, Map<Char, Int>>()
    val result = mutableListOf<MutableList<String>>()

    for (word in words) {
        val chars = HashMap<Char, Int>()
        for (char in word) {
            chars.putIfAbsent(char, 0)
            chars.computeIfPresent(char) { _, v -> v + 1 }
        }

        var isMatch = false
        for (anagram in anagramMap) {
            isMatch = true
            anagram.value.forEach {
                if (it.value != chars[it.key])
                    isMatch = false
            }
            if (isMatch) {
                result[anagram.key].add(word)
                break
            }
        }
        if (isMatch.not()) {
            anagramMap[anagramMap.size] = chars
            result.add(mutableListOf(word))
        }
    }

    return result
}

// Tech
//def hashkey(str):
//    return "".join(sorted(str))
//
//def hashkey2(str):
//    arr = [0] * 26
//    for c in str:
//        arr[ord(c) - ord('a')] += 1
//    return tuple(arr)
//
//def groupAnagramWords(strs):
//    groups = collections.defaultdict(list)
//    for s in strs:
//        groups[hashkey2(s)].append(s)
//
//    return tuple(groups.values())
//
//print(groupAnagramWords(['abc', 'bcd', 'cba', 'cbd', 'efg']))