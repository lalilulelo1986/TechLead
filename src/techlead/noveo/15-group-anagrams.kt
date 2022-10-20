package techlead.noveo

fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    println(groupAnagrams(strs))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val result = HashMap<String, MutableList<String>>()
    strs.forEach { str ->
        val array = IntArray(26)
        str.forEach {
            val charCode = 25 - ('z'.code - it.code)
            array[charCode] = array[charCode] + 1
        }
        val sb = buildString {
            array.forEachIndexed { index, i ->
                for (s in 1..i)
                    this.append(Char('a'.code + index))
            }
        }
        result.computeIfAbsent(sb) { mutableListOf() }
        result.computeIfPresent(sb) { _, v -> v.also { it.add(str) } }
    }
    return result.values.toList()
}

fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()
    strs.forEach { str ->
        val sorted = str.toCharArray().sorted().toString()
        map.computeIfAbsent(sorted) { mutableListOf() }
        map.computeIfPresent(sorted) { _, v -> v.also { it.add(str) } }
    }
    return map.values.toList()
}