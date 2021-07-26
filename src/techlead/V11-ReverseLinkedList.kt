package techlead

import java.util.*

fun main() {
    val ll = LinkedList<Int>().apply {
        add(1); add(2); add(3); add(4); add(5)
    }
    ReverseLinkedList().reverse(ll)

    val linkedList = LinkedNode(6).also { it.next = LinkedNode(4).also { it.next = LinkedNode(2) } }
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

class ReverseLinkedList2 {
    fun reverse(linkedList: LinkedNode<Int>) {
        for ()
    }
}