package techlead.noveo

import techlead.LinkedNode
import java.util.PriorityQueue

fun main() {
    val lists = listOf(
        LinkedNode(1).also { it.next = LinkedNode(4).also { it.next = LinkedNode(5) } },
        LinkedNode(1).also { it.next = LinkedNode(3).also { it.next = LinkedNode(4) } },
        LinkedNode(2).also { it.next = LinkedNode(6) },
    )
    println(mergeKListsHeap(lists))

    println(mergeKListsHeap(listOf()))
}

fun mergeKListsHeap(lists: List<LinkedNode<Int>>): LinkedNode<Int>? {
    val heap = PriorityQueue<Int>()
    lists.forEach {
        var curr: LinkedNode<Int>? = it
        while (curr != null) {
            heap.add(curr!!.value)
            curr = curr!!.next
        }
    }
    val result = LinkedNode(Int.MIN_VALUE)
    var curr = result
    while (heap.isNotEmpty()) {
        curr.next = LinkedNode(heap.remove())
        curr = curr.next!!
    }
    return result.next
}

fun mergeKLists(lists: List<LinkedNode<Int>>): LinkedNode<Int>? {
    var result: LinkedNode<Int>? = LinkedNode(Int.MIN_VALUE)
    lists.forEach {
        result = mergehelper(result!!, it)
    }
    return result?.next
}

fun mergehelper(one: LinkedNode<Int>, two: LinkedNode<Int>): LinkedNode<Int>? {
    val result = LinkedNode(Int.MIN_VALUE)
    var curr = result
    var localOne: LinkedNode<Int>? = one
    var localTwo: LinkedNode<Int>? = two
    while (localOne != null || localTwo != null) {
        if (localOne == null || localOne.value >= (localTwo?.value ?: Int.MIN_VALUE) && localTwo != null) {
            curr.next = LinkedNode(localTwo!!.value)
            curr = curr.next!!
            localTwo = localTwo.next
            continue
        }
        if (localTwo == null || localOne.value < localTwo.value) {
            curr.next = LinkedNode(localOne.value)
            curr = curr.next!!
            localOne = localOne.next
            continue
        }
    }

    return result.next
}