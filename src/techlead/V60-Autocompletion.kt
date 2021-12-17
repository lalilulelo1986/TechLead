package techlead

import techlead.common.Tree
import techlead.common.TrieNode
import java.util.*
import kotlin.collections.HashMap

fun main() {
    println(Solution60("dog", "dogs", "dark", "cat", "door", "dodge").autoComplete("dog").toList())

    println(Solution60_2("dog", "dogs", "dark", "cat", "door", "dodge").autoComplete("dog").toList())
}

// My index like tree. with bug
class Solution60(vararg words: String) {
    private val map = HashMap<Char, Tree<Char>>()
    private var curr: Tree<Char>? = null

    init {
        for (word in words) {
            if (map[word.first()] == null) {
                val newNode = Tree(word.first())
                map[word.first()] = newNode
                curr = newNode
            } else {
                curr = map[word.first()]
            }
            for (ind in 1 until word.length) {
                curr = curr?.children?.find { it.value == word[ind] } ?: run {
                    val newNode = Tree(word[ind])
                    curr?.children?.add(newNode)
                    newNode
                }
            }
        }
    }

    fun autoComplete(str: String): Array<String> {
        val root = map[str.firstOrNull()]
        if (root != null)
            return doDfs(str, root).toTypedArray()
        else
            return emptyArray()
    }

    fun doDfs(str: String, tree: Tree<Char>): List<String> {
        val result = mutableListOf<String>()
        val stack = Stack<Pair<Tree<Char>, Int>>()
        val strBuilder = StringBuilder(36)
        stack.push(tree to 0)
        while (stack.isNotEmpty()) {
            val popped = stack.pop()
            strBuilder.delete(popped.second, Int.MAX_VALUE)
            strBuilder.append(popped.first.value)
            if (popped.first.children.isEmpty() && strBuilder.length >= str.length) {
                result.add(strBuilder.toString())
                continue
            }
            popped.first.children.forEach {
                if (popped.second + 1 >= str.length || str[popped.second + 1] == it.value)
                    stack.push(it to popped.second + 1)
            }
        }

        return result
    }
}

// Using Trie data structure
class Solution60_2(vararg words: String) {
    var root: TrieNode = TrieNode()

    init {
        for (word in words) {
            var curr = root
            for (c in word.indices) {
                if (curr.children[word[c]] == null) {
                    curr.children[word[c]] = TrieNode(value = curr.value + word[c], isWord = c == word.length - 1)
                    curr = curr.children[word[c]]!!
                } else {
                    curr = curr.children[word[c]]!!
                    if (c == word.length - 1)
                        curr.isWord = true
                }
            }
        }
    }

    fun autoComplete(str: String): Array<String> {
        var startRoot: TrieNode? = root
        if (root.children.isNotEmpty())
            for (c in str) {
                startRoot = startRoot?.children?.get(c)
            }
        if (startRoot != null)
            return doDfs(startRoot).toTypedArray()
        else
            return emptyArray()
    }

    fun doDfs(tree: TrieNode): List<String> {
        val result = mutableListOf<String>()
        val stack = Stack<TrieNode>()
        stack.push(tree)
        while (stack.isNotEmpty()) {
            val popped = stack.pop()
            if (popped.isWord)
                result.add(popped.value)
            popped.children.forEach {
                stack.push(it.value)
            }
        }
        return result
    }
}