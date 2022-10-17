package techlead.noveo

import techlead.common.Node
import java.util.*
import kotlin.test.assertEquals

fun main() {
    val node = Node(8).also {
        it.left = Node(4).also {
            it.left = Node(2)
            it.right = Node(6)
        }
        it.right = Node(12).also {
            it.left = Node(10)
            it.right = Node(14)
        }
    }

    assertEquals(10 to 12, floorAndCeil(node, 11))
    assertEquals(-1  to 2, floorAndCeil(node, 1))
    assertEquals(6 to 6, floorAndCeil(node, 6))
    assertEquals(14 to -1, floorAndCeil(node, 15))
}

fun floorAndCeil(node: Node<Int>?, number: Int): Pair<Int?, Int?> {
    var ceil: Int? = null
    var floor: Int? = null
    val stack = Stack<Node<Int>>()
    if (node != null)
        stack.push(node)

    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        if (pop.value!! <= number && (pop.value!! >= (floor ?: Int.MIN_VALUE)))
            floor = pop.value!!
        if (pop.value!! >= number && (pop.value!! <= (ceil ?: Int.MAX_VALUE)))
            ceil = pop.value!!

        if (pop.value!! > number) {
            if (pop.left == null)
                break
            stack.push(pop.left)
        }
        if (pop.value!! < number) {
            if (pop.right == null)
                break
            stack.push(pop.right)
        }
    }

    return (floor ?: -1) to (ceil ?: -1)
}
