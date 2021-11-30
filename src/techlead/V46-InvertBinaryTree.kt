package techlead

import techlead.common.Node

fun main() {
    val tree = Node("a").also {
        it.left = Node("b").also {
            it.left = Node("d")
            it.right = Node("e")
        }
        it.right = Node("c").also {
            it.right = Node("f")
        }
    }

    println(tree)
    println(reverse(tree))
    println(reverse(tree))
    println(reverse2(tree))
    println(reverse2(tree))
}

// My
fun <T> reverse(node: Node<T>?): Node<T>? {
    if (node == null)
        return node

    val tmp = node.left
    node.left = node.right
    node.right = tmp
    reverse(node.left)
    reverse(node.right)

    return node
}

// Tech
fun <T> reverse2(node: Node<T>?): Node<T>? {
    if (node == null)
        return node

    val left = reverse(node.left)
    val right = reverse(node.right)
    node.left = right
    node.right = left

    return node
}