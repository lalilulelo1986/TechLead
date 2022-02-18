package techlead

import techlead.common.Node

fun main() {
    val root = Node(1).also {
        it.left = Node(2).also {
            it.left = Node(4)
            it.right = Node(5).also {
                it.right = Node(1)
            }
        }
        it.right = Node(2).also {
            it.left = Node(5).also {
                it.left = Node(1)
            }
            it.right = Node(4)
        }
    }
    println(isSymmetric(root.left, root.right))
}

fun isSymmetric(node1: Node<Int>?, node2: Node<Int>?): Boolean {
    if (node1 == null && node2 == null)
        return true
    if (node1?.value == node2?.value)
        return isSymmetric(node1?.left, node2?.right) && isSymmetric(node1?.right, node2?.left)
    return false
}