package techlead

import techlead.common.Node

/*
    Return array witch contains all elements of N-th Height in Binary Tree
          1
        /   \
       /     \
      2       3
     / \       \
    4   5       7   if 3 return [4, 5, 7]
 */
fun main() {
    val tree = Node(1).also {
        it.left = Node(2).also {
            it.left = Node(4)
            it.right = Node(5)
        }
        it.right = Node(3).also {
            it.right = Node(7)
        }
    }
    println(elementsOfHeight(tree, 3))
}

fun elementsOfHeight(node: Node<Int>, height: Int): List<Int> {
    val elements = mutableListOf<Int>()
    elements.addAll(traverse(node, height, 1))

    return elements
}

fun traverse(node: Node<Int>?, height: Int, currHeight: Int): List<Int> {
    if (node == null) return emptyList()
    if (height == currHeight)
        return listOf(node.value!!)

    return traverse(node.left, height, currHeight + 1) + traverse(node.right, height, currHeight + 1)
}

