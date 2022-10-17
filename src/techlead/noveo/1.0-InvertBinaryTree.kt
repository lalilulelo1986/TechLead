package techlead.noveo

import techlead.common.Node

fun main() {
    val rootNode = Node(4).also {
        it.left = Node(2).also {
            it.left = Node(1)
            it.right = Node(3)
        }
        it.right = Node(7).also {
            it.left = Node(6)
            it.right = Node(9)
        }
    }

    // before
    println(rootNode)
    invertTree(rootNode)
    // after
    println(rootNode)
}

// Queue
fun <T> invertTree(root: Node<T>) {
    val queue = ArrayDeque<Node<T>>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val new = queue.removeFirst()
        // swap
        new.left = new.right?.also { new.right = new.left }
        new.left?.let { queue.add(it) }
        new.right?.let { queue.add(it) }
    }
}

// DFS
fun <T> invertTreeDFS(node: Node<T>) {
    // swap
    node.left = node.right?.also { node.right = node.left }
    node.left?.let { invertTreeDFS(it) }
    node.right?.let { invertTreeDFS(it) }
}