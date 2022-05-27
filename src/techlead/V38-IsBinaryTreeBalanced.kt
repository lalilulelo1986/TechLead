package techlead

import techlead.common.Node
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

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
    val noBalancedTree = Node(1).also {
        it.left = Node(2).also {
            it.left = Node(4)
        }
    }

    println(isBalanced(tree))
    println(isBalanced2(tree))
    println(isBalanced(noBalancedTree))
    println(isBalanced2(noBalancedTree))
}

// My
fun <T> isBalanced(node: Node<T>): Boolean {
    val maxMin = maxMin(node, 1)
    if (maxMin.first - maxMin.second > 1)
        return false
    return true
}

fun <T> maxMin(node: Node<T>?, height: Int = 1): Pair<Int, Int> {
    if (node == null)
        return Pair(height, height)

    val leftMaxMin = maxMin(node.left, height + 1)
    val rightMaxMin = maxMin(node.right, height + 1)
    return Pair(
        max(max(leftMaxMin.first, leftMaxMin.second), max(rightMaxMin.first, rightMaxMin.second)),
        min(min(leftMaxMin.first, leftMaxMin.second), min(rightMaxMin.first, rightMaxMin.second)),
    )
}

// Tech
fun <T> isBalanced2(node: Node<T>?): Pair<Boolean, Int> {
    if (node == null)
        return true to 0

    val leftResult: Pair<Boolean, Int> = isBalanced2(node.left)
    val rightResult: Pair<Boolean, Int> = isBalanced2(node.right)
    return (leftResult.first && rightResult.first && abs(leftResult.second - rightResult.second) <= 1) to max(
        leftResult.second,
        rightResult.second
    ) + 1
}

// TechLead
//class Solution(object):
//    # return value (isBalanced, height)
//    def _is_balanced_helper(self, n):
//        if not n:
//            return (True, 0)
//
//        lBalanced, lHeight = self._is_balanced_helper(n.left)
//        rBalanced, rHeight = self._is_balanced_helper(n.right)
//        return (lBalanced and rBalanced and abs(lHeight - rHeight) <= 1,
//            max(lHeight, rHeight) + 1)
//
//    def is_balanced(self, n):
//        return self._is_balanced_helper(n)[0]