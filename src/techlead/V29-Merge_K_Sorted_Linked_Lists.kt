package techlead

fun main() {
    val list1 = LinkedNode(1).also {
        it.next = LinkedNode(3).also { it.next = LinkedNode(5) }
    }
    val list2 = LinkedNode(2).also {
        it.next = LinkedNode(4).also { it.next = LinkedNode(6) }
    }
    println(merge(list1, list2))
}

fun merge(list1: LinkedNode<Int>?, list2: LinkedNode<Int>?): LinkedNode<Int>? {
    val result: LinkedNode<Int> = LinkedNode(0)
    var p: LinkedNode<Int>? = result
    var p1 = list1
    var p2 = list2

    while (p1 != null || p2 != null) {
        if (p1 == null) {
            p?.next = p2
            p = p?.next
            p2 = p2?.next
            continue
        }
        if (p2 == null) {
            p?.next = p1
            p = p?.next
            p1 = p1?.next
            continue
        }
        if (p1!!.value > p2!!.value) {
            p?.next = p2
            p = p?.next
            p2 = p2.next
        } else {
            p?.next = p1
            p = p?.next
            p1 = p1.next
        }
    }

    return result.next
}