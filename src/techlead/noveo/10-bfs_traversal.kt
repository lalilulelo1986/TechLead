package techlead.noveo

import techlead.common.Node

fun main() {
    val root = Node(3).also {
        it.left = Node(5).also {
            it.left = Node(6)
            it.right = Node(2).also {
                it.left = Node(7)
                it.right = Node(4)
            }
        }
        it.right = Node(1).also {
            it.left = Node(0)
            it.right = Node(8)
        }
    }
    bfs_traversal(root)
}

fun <T> bfs_traversal(node: Node<T>) {
    val queue = java.util.ArrayDeque<Node<T>>()
    queue.add(node)

    while (queue.isNotEmpty()) {
        val pop = queue.pop()
        print(pop.value)
        pop.left?.let { queue.add(it) }
        pop.right?.let { queue.add(it) }
    }
}