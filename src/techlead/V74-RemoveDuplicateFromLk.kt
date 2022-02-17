package techlead

fun main() {
    // 1 -> 2 -> 2 -> 3 -> 3 -> 2
    val list = LinkedNode(1).also {
        it.next = LinkedNode(1).also {
            it.next = LinkedNode(2).also {
                it.next = LinkedNode(3).also {
                    it.next = LinkedNode(3)
                }
            }
        }
    }
    println(removeDuplicate(list))

    // 1 -> 2 -> 2 -> 3 -> 3
    val list2 = LinkedNode(1).also {
        it.next = LinkedNode(2).also {
            it.next = LinkedNode(2).also {
                it.next = LinkedNode(3).also {
                    it.next = LinkedNode(3)
                }
            }
        }
    }
    println(removeDuplicate2(list2))
}

fun removeDuplicate(list: LinkedNode<Int>?): LinkedNode<Int>? {
    val head = LinkedNode(-1).also { it.next = list }
    val visited = HashSet<Int>()

    var tail = head
    var curr = head
    while (curr.next != null) {
        if (visited.contains(curr.next?.value!!).not()) {
            visited.add(curr.next?.value!!)
            tail.next = curr.next
            tail = tail.next!!
        }
        curr = curr.next!!
    }
    tail.next = null

    return head.next
}

fun removeDuplicate2(list: LinkedNode<Int>?): LinkedNode<Int>? {
    var curr = list
    while (curr?.next != null) {
        if (curr.value == curr.next?.value) {
            curr.next = curr.next?.next
        }
        curr = curr.next
    }
    return list
}