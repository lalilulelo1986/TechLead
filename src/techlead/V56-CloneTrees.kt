package techlead

import techlead.common.Node
import java.util.*

/*
#  1
# / \
#2   3
#   / \
#  4*  5
a = Node(1)
a.left = Node(2)
a.right = Node(3)
a.right.left = Node(4)
a.right.right = Node(5)

b = Node(1)
b.left = Node(2) 
b.right = Node(3)
b.right.left = Node(4)
b.right.right = Node(5)

print(findNode2(a, b, a.right.left))
# 4
 */
fun main() {
    val a = Node(1).also {
        it.left = Node(2)
        it.right = Node(3).also {
            it.left = Node(4)
            it.right = Node(5)
        }
    }
    val b = Node(1).also {
        it.left = Node(2)
        it.right = Node(3).also {
            it.left = Node(4)
            it.right = Node(5)
        }
    }
    println(findClone(a, b, a.right!!.left!!))
}

fun findClone(a: Node<Int>, b: Node<Int>, target: Node<Int>): Node<Int>? {
    val stack = Stack<Node<Int>>()
    stack.push(a)
    stack.push(b)
    while (stack.isNotEmpty()) {
        val a1 = stack.pop()
        val b1 = stack.pop()
        if (a1 == target)
            return b1
        if (a1.left != null) {
            stack.push(a1.left)
            stack.push(b1.left)
        }
        if (a1.right != null) {
            stack.push(a1.right)
            stack.push(b1.right)
        }
    }

    return null
}