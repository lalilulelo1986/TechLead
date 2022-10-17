package techlead.noveo

import techlead.common.Node
import kotlin.test.assertEquals

fun main() {
    // given
    val node = Node(10).also {
        it.left = Node(5).also {
            it.left = Node(3)
            it.right = Node(7)
        }
        it.right = Node(15).also {
            it.right = Node(18)
        }
    }
    // then
    assertEquals(32, rangeSumBST(node, 7, 15))

    // given
    val node2 = Node(10).also {
        it.left = Node(5).also {
            it.left = Node(3).also {
                it.left = Node(1)
            }
            it.right = Node(7).also {
                it.left = Node(6)
            }
        }
        it.right = Node(15).also {
            it.left = Node(13)
            it.right = Node(18)
        }
    }
    // then
    assertEquals(23, rangeSumBST(node2, 6, 10))
}

fun rangeSumBST(root: Node<Int>, low: Int, high: Int): Int? {
    var sum: Int? = null
    val queue = java.util.ArrayDeque<Node<Int>>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val curr = queue.pop()
        if (curr.value!! in low..high) {
            sum = (sum ?: 0) + curr.value!!
        }
        curr.left?.let { queue.add(it) }
        curr.right?.let { queue.add(it) }
    }

    return sum
}