package techlead.noveo

import techlead.LinkedNode
import kotlin.math.ceil

fun main() {
    val lists = listOf(
        LinkedNode(1).also { it.next = LinkedNode(4).also { it.next = LinkedNode(5) } },
        LinkedNode(1).also { it.next = LinkedNode(3).also { it.next = LinkedNode(4) } },
        LinkedNode(2).also { it.next = LinkedNode(6) },
    )
    println(mergeKLists(lists))

    println(mergeKLists(listOf()))
}

fun mergeKLists(lists: List<LinkedNode<Int>>): LinkedNode<Int>? {
    var result: LinkedNode<Int>? = LinkedNode(Int.MIN_VALUE)
    lists.forEach {
        result = merge2(result!!, it)
    }
    return result?.next
}

fun merge2(one: LinkedNode<Int>, two: LinkedNode<Int>): LinkedNode<Int>? {
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