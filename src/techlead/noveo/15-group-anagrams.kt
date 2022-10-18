package techlead.noveo

fun main() {
    val strs = arrayOf("eat","tea","tan","ate","nat","bat")
    println(groupAnagrams(strs))

    val strs2 = arrayOf<String>()
    println(groupAnagrams(strs2))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()
    strs.forEach { str ->
        val sorted = str.toCharArray().sorted().toString()
        map.computeIfAbsent(sorted) { mutableListOf() }
        map.computeIfPresent(sorted) { _, v -> v.also { it.add(str) } }
    }
    return map.values.toList()
}