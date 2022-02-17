package techlead

import techlead.common.Node
import kotlin.io.path.createTempDirectory

// find next largest value
fun main() {
    // given binary search tree
    val a = Node(4).also { f4 ->
        f4.left = Node(2).also { f2 ->
            f2.parent = f4
            f2.left = Node(1).also {
                it.parent = f2
            }
        }
        f4.right = Node(8).also { f8 ->
            f8.parent = f4
            f8.left = Node(5).also { f5 ->
                f5.parent = f8
                f5.right = Node(7).also {
                    it.parent = f5
                }
            }
            f8.right = Node(9).also {
                it.parent = f8
            }
        }
    }
    println(nextBiggerValue(a, a.right!!))
    println(nextBigVal(a.right!!))
    println(nextBiggerValue(a, a.left!!))
    println(nextBigVal(a.left!!))
    println(nextBiggerValue(a, a.right!!.left!!.right!!))
    println(nextBigVal(a.right!!.left!!.right!!))
    println(nextBiggerValue(a, a))
    println(nextBigVal(a))
}

fun nextBiggerValue(a: Node<Int>?, b: Node<Int>): Node<Int>? {
    if (a == null)
        return null

    var curr: Node<Int>? = null
    if (a.value!! > b.value!!)
        curr = a

    val next = if (a.value!! > b.value!!)
        nextBiggerValue(a.left, b)
    else nextBiggerValue(a.right, b)

    if (curr == null)
        curr = next
    else if (next?.value != null && next.value!! > b.value!! && next.value!! < curr.value!!)
        curr = next

    return curr
}

// using parent
fun nextBigVal(node: Node<Int>): Int? {
    var result: Int?

    var curr = node.right
    result = node.right?.value
    while (curr?.left != null) {
        result = curr.left?.value
        curr = curr.left
    }

    if (result == null) {
        curr = node
        while (curr?.parent != null) {
            val parent = curr.parent
            if (parent?.left == curr) {
                result = parent.value
                break
            }
            curr = parent!!
        }
    }

    return result
}