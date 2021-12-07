package techlead

import java.util.*
import kotlin.collections.HashMap

//print(chainedWords(['apple', 'eggs', 'snack', 'karat', 'tuna']))
//# True
//
//print(chainedWords(['apple', 'eggs', 'snack', 'karat', 'tunax']))
//# False

fun main() {
    val arr = arrayOf("apple", "eggs", "snack", "karat", "tuna")
    val arr2 = arrayOf("apple", "eggs", "snack", "karat", "tunax")
    val arr3 = arrayOf("apple", "karat", "tuna", "eggs", "snack", "alli", "ibba", "alli", "isdf", "fdsa")
    println(Solution51(arr).townGame())
    println(Solution51(arr2).townGame())
    println(Solution51(arr3).townGame())
}

class Solution51(val array: Array<String>) {
    val startMap = HashMap<Char, MutableList<Int>>()
    val visited = arrayOfNulls<Int>(array.size)
    var isCircle = false

    fun townGame(): Boolean {
        for (i in array.indices) {
            startMap.computeIfPresent(array[i].first()) { _, v -> v.also { it.add(i) } }
            startMap.putIfAbsent(array[i].first(), mutableListOf(i))
        }
        println(startMap)
        helper(array.first())
        return isCircle
    }

    private fun helper(str: String, depth: Int = 0) {
        if (depth == array.size)
            isCircle = true
        startMap[str.last()]?.forEach {
            if (visited[it] == null) {
                visited[it] = 1
                helper(array[it], depth + 1)
                visited[it] = null
            }
        }
    }
}

// TechLead
//import collections
//
//def is_cycle_dfs(symbol, current_word, start_word, length, visited):
//  if length == 1:
//      return start_word[0] == current_word[-1]
//
//  visited.add(current_word)
//  for neighbor in symbol[current_word[-1]]:
//      if (neighbor not in visited and
//          is_cycle_dfs(symbol, neighbor, start_word, length - 1, visited)):
//        return True
//  visited.remove(current_word)
//  return False
//
//def chainedWords(words):
//  symbol = collections.defaultdict(list)
//  for word in words:
//      symbol[word[0]].append(word)
//
//  return is_cycle_dfs(symbol, words[0], words[0], len(words), set())
//
//print(chainedWords(['apple', 'eggs', 'snack', 'karat', 'tuna']))
//# True
//
//print(chainedWords(['apple', 'eggs', 'snack', 'karat', 'tunax']))
//# False