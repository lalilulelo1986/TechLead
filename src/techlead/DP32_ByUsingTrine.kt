package techlead

import techlead.common.TrieNode
import java.time.Instant

//https://www.geeksforgeeks.org/top-20-dynamic-programming-interview-questions/?ref=lbp
private val trie = TrieNode()
fun main() {
    val dictionary = listOf(
        "i", "mobile", "samsung", "sam", "sung", "man",
        "mango", "icecream", "and", "go",
        "like", "ice", "cream", "qwerty", "qwe"
    )
    initTrie(dictionary)

    val curr = Instant.now().toEpochMilli()

    for (i in 1..1) {
        println(isWordBreaked("qwerty"))
        isWordBreaked("ilikesamsung")
        isWordBreaked("iiiiiiii")
        isWordBreaked("")
        isWordBreaked("samsungandmango")
        isWordBreaked("ilikesamsung")
        isWordBreaked("samsungandmangok")
    }
    println(Instant.now().toEpochMilli() - curr)
}

fun isWordBreaked(word: String, ind: Int = 0): Boolean {
    if (ind >= word.length)
        return true

    var currNode: TrieNode = trie
    for (i in ind until word.length) {
        if (currNode.children[word[i]] != null) {
            if (currNode.children[word[i]]!!.isWord && isWordBreaked(word, i + 1))
                return true
            currNode = currNode.children[word[i]]!!
        }
    }
    return false
}

fun initTrie(dictionary: List<String>) {
    var currNode: TrieNode
    dictionary.forEach { str ->
        currNode = trie
        str.forEachIndexed { ind, char ->
            if (currNode.children[char] == null) {
                val newNode = TrieNode().also { if (ind == str.length - 1) it.isWord = true }
                currNode.children[char] = newNode
                currNode = newNode
            } else {
                if (ind == str.length - 1) {
                    currNode.children[char]!!.also { it.isWord =  true }
                }
                currNode = currNode.children[char]!!
            }
        }
    }
}
//
//fun traverse() {
//    val queue: Queue<TrieNode> = ArrayDeque()
//    queue.offer(trie)
//    while (queue.isNotEmpty()) {
//        val poll = queue.poll()
//
//    }
//}