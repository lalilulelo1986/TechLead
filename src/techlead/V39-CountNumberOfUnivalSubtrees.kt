package techlead

import techlead.common.Node

// uniVal tree is tree with same values
fun main() {
    val tree = Node(0).also {
        it.left = Node(1)
        it.right = Node(0).also {
            it.left = Node(1).also {
                it.left = Node(1)
                it.right = Node(1)
            }
            it.right = Node(0)
        }
    }
    println(countUnivalSubTrees2(tree))
}

fun countUnivalSubTrees(node: Node<Int>?): Pair<Boolean, Int> {
    if (node == null)
        return Pair(true, 0)

    val leftTree = countUnivalSubTrees(node.left)
    val rightTree = countUnivalSubTrees(node.right)
    val currBalanced = leftTree.first && rightTree.first && node.value == (node.left?.value
        ?: node.value) && node.value == (node.right?.value ?: node.value)
    return Pair(
        leftTree.first && rightTree.first && node.value == (node.left?.value
            ?: node.value) && node.value == (node.right?.value ?: node.value),
        leftTree.second + rightTree.second + if (currBalanced) 1 else 0
    )
}

// My new. Seems worked
fun countUnivalSubTrees2(node: Node<Int>?): Boolean {
    if (node == null)
        return true

    val leftTree = countUnivalSubTrees2(node.left)
    val rightTree = countUnivalSubTrees2(node.right)
    val currBalanced = leftTree && rightTree && node.value == (node.left?.value
        ?: node.value) && node.value == (node.right?.value ?: node.value)
    return currBalanced
}