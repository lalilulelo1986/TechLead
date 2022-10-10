package techlead

import techlead.common.Node
import java.util.*
import kotlin.test.assertEquals

/*
* Есть бинарное дерево поиска с N числами и заданное число. Нужно найти в дереве первое число, которое строго больше этого заданного. При этом само заданное число может в дереве не присутствовать. Должно работать за O(Log N).
*                       7
*                   /       \
*                 4           9
*               /   \       /   \
*             2      6     8     20
*            /      /           /
*           1      5           15
* */
fun main() {
    val node = Node(7).also {
        it.left = Node(4).also {
            it.left = Node(2).also {
                it.left = Node(1)
            }
            it.right = Node(6).also {
                it.left = Node(5)
            }
        }
        it.right = Node(9).also {
            it.left = Node(8)
            it.right = Node(20).also {
                it.left = Node(15)
            }
        }
    }

    assertEquals(1, findNextInBinaryTree(node, -100))
    assertEquals(1, findNextInBinaryTree(node, 0))
    assertEquals(2, findNextInBinaryTree(node, 1))
    assertEquals(4, findNextInBinaryTree(node, 3))
    assertEquals(8, findNextInBinaryTree(node, 7))
    assertEquals(15, findNextInBinaryTree(node, 13))
    assertEquals(null, findNextInBinaryTree(node, 100))
}

// using stack
fun findNextInBinaryTree(node: Node<Int>?, number: Int): Int? {
    var nextMax: Int? = null
    val stack = Stack<Node<Int>>()
    if (node != null)
        stack.push(node)

    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        if (pop.value!! > number && (pop.value!! < (nextMax ?: Int.MAX_VALUE)))
            nextMax = pop.value!!

        if (pop.value!! > number) {
            if (pop.left == null)
                break
            stack.push(pop.left)
        }
        if (pop.value!! <= number) {
            if (pop.right == null)
                break
            stack.push(pop.right)
        }
    }

    return nextMax
}