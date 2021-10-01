package techlead

import techlead.common.Node

fun main() {
    val list1 = LinkedNode(1)
        .also {
            it.next = LinkedNode(2)
                .also { it.next = LinkedNode(3).also { it.next = LinkedNode(4).also { it.next = LinkedNode(5) } } }
        }
    println(Solution21.cutLastKElement(list1, 4))
}

// 2 pointers
class Solution21 {
    companion object {
        fun cutLastKElement(linkList: LinkedNode<Int>?, lastRemove: Int): LinkedNode<Int>? {
            var slow: LinkedNode<Int>? = null
            var fast = linkList
            for (i in 1 until lastRemove)
                fast = fast?.next
            if (fast == null)
                return linkList
            if (fast.next == null)
                return linkList?.next

            while (fast != null) {
                if (fast.next != null)
                    slow = linkList
                fast = fast.next
            }
            println("slow: $slow")
            slow.also {
                val afterDeleted = it?.next?.next
                it?.next?.next = null
                it?.next = afterDeleted
            }
            return linkList
        }
    }
}

