package techlead

import techlead.common.Node
import kotlin.math.max

fun main() {
    val root = Node(5).also {
        it.left = Node(1).also {
            it.left = Node(0)
        }
        it.right = Node(6)
    }

    println("depth = ${binaryTreeDepth(root)}")
}

// My recursion
fun <T> binaryTreeDepth(node: Node<T>?, depth: Int = 0): Int {
    if (node == null)
        return depth

    val leftDepth = binaryTreeDepth(node.left, depth + 1)
    val rightDepth = binaryTreeDepth(node.right, depth + 1)

    return max(leftDepth, rightDepth)
}
