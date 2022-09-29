package techlead

import techlead.common.Node
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.max

// NO RECURSION!!!
fun main() {
    val tree = Node(1).also {
        it.left = Node(2).also {
            it.left = Node(4).also {
                it.right = Node(6).also {
                    it.left = Node(33)
                }
            }
        }
        it.right = Node(3).also {
            it.left = Node(7)
            it.right = Node(8)
        }
    }
    println("height: " + maxDepth(tree))
    println("height: " + findDepth(tree))
    println("height: " + findDepthQueue(tree))
    println("height: " + findDepthRecursion(tree))
}

// My
fun <T> maxDepth(node: Node<T>?): Int {
    if (node == null) return 0
    var maxHeight = 0
    var height = 1
    val stack = Stack<Node<T>>()
    stack.push(node)
    var previous: Node<T>? = null

    while (stack.isNotEmpty()) {
        val peek = stack.peek()
        if ((peek?.left == null && peek?.right == null) || (previous == peek.left && peek.right == null) || (previous == peek.right)) {
            maxHeight = max(maxHeight, height)
            height--
            previous = stack.pop()
        } else if (previous != peek.left && peek.left != null) {
            previous = stack.peek()
            stack.push(stack.peek()?.left)
            height++
        } else if (previous != peek.right && peek.right != null) {
            previous = stack.peek()
            stack.push(stack.peek()?.right)
            height++
        }
    }
    return maxHeight
}

// TechLead Stack
fun <T> findDepth(node: Node<T>?): Int {
    val stack = Stack<Pair<Node<T>?, Int>>()
    stack.push(node to 1)

    var maxDepth = 0
    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        maxDepth = max(maxDepth, pop.second)
        if (pop?.first?.left != null)
            stack.push(pop.first?.left to pop.second + 1)
        if (pop?.first?.right != null)
            stack.push(pop.first?.right to pop.second + 1)
    }

    return maxDepth
}

// My Queue
fun <T> findDepthQueue(node: Node<T>): Int {
    val queue: Queue<Node<T>> = java.util.ArrayDeque()
    queue.add(node)

    var size = queue.size
    var maxDepth = 0
    while (queue.isNotEmpty()) {
        val pop = queue.poll()
        if (pop.left != null) queue.add(pop.left!!)
        if (pop.right != null) queue.add(pop.right!!)
        size--
        if (size == 0) {
            size = queue.size
            maxDepth++
        }
    }

    return maxDepth
}

// My recursion
fun <T> findDepthRecursion(node: Node<T>?): Int {
    if (node == null) return 0
    return max(findDepthRecursion(node.left), findDepthRecursion(node.right)) + 1
}