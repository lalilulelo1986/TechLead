package techlead

import java.util.*

fun main() {
//    val ll = LinkedList<Int>().apply {
//        add(1); add(2); add(3); add(4); add(5)
//    }
//    ReverseLinkedList().reverse(ll)

    val linkedList = LinkedNode(1).also { it.next = LinkedNode(2).also { it.next = LinkedNode(3) } }
    println(linkedList)
    ReverseLinkedList2().reverse(linkedList)

}

// new List
class ReverseLinkedList {
    fun reverse(linkedList: LinkedList<Int>) {
        val result = LinkedList<Int>()
        linkedList.forEach {
            result.add(0, it)
        }
        println(result)
    }
}

// GOOD. with no new list
class ReverseLinkedList2 {
    fun reverse(linkedList: LinkedNode<Int>?) {
        var previous: LinkedNode<Int>? = null
        var current = linkedList
        while (current != null) {
            val next = current.next
            current.next = previous
            previous = current
            current = next
        }
        println(previous)
    }
}