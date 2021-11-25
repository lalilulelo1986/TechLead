package techlead

import kotlin.math.abs
import kotlin.math.min

fun main() {
    val intNode = LinkedNode(99)
        .also {
            it.next = LinkedNode(6)
                .also { it.next = LinkedNode(7).also { it.next = LinkedNode(8).also { it.next = LinkedNode(9) } } }
        }
    val list1 = LinkedNode(1)
        .also {
            it.next = intNode
        }

    val list2 = LinkedNode(1)
        .also {
            it.next = LinkedNode(2)
                .also { it.next = LinkedNode(3).also { it.next = LinkedNode(4).also { it.next = intNode } } }
        }

    println(intersection(list1, list2)?.value)
}

fun intersection(listA: LinkedNode<Int>?, listB: LinkedNode<Int>?): LinkedNode<Int>? {

    val lenA = run {
        var length = 0
        var point = listA
        while (point != null) {
            length++
            point = point.next
        }
        length
    }

    val lenB = run {
        var length = 0
        var point = listB
        while (point != null) {
            length++
            point = point?.next
        }
        length
    }

    val lenDiff = abs(lenA - lenB)

    var currA = listA
    var currB = listB
    if (lenA > lenB)
        for (step in 1..lenDiff)
            currA = currA?.next
    else
        for (step in 1..lenDiff)
            currB = currB?.next

    for (step in 1..min(lenA, lenB)) {
        if (currA == currB) {
            return currA
        } else {
            currA = currA?.next
            currB = currB?.next
        }
    }
    return null
}