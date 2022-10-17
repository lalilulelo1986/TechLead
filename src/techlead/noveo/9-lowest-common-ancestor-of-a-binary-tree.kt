package techlead.noveo

import techlead.common.Node
import kotlin.test.assertEquals

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

    assertEquals(3, Solution9().lowestCommonAncestor(root, root.left!!, root.right!!))
    assertEquals(5, Solution9().lowestCommonAncestor(root, root.left!!, root.left!!.right!!.right!!))
}

class Solution9 {
    val map = kotlin.collections.HashMap<Node<Int>, Int>()
    var found = false
    var result: Node<Int>? = null

    fun lowestCommonAncestor(root: Node<Int>, p: Node<Int>, q: Node<Int>): Int? {
        fillPath(root, p)
        found = false
        fillPath(root, q)
        return result?.value
    }

    private fun fillPath(root: Node<Int>, node: Node<Int>) {
        if (result != null)
            return

        if (root.value == node.value)
            found = true
        if (found.not())
            root.left?.let { fillPath(it, node) }
        if (found.not())
            root.right?.let { fillPath(it, node) }

        if (found) {
            map.computeIfAbsent(root) { 0 }
            map.computeIfPresent(root) { _, v -> v + 1 }
            if (map[root] == 2 && result == null)
                result = root
        }
    }
}