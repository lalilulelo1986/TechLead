package techlead.noveo

import techlead.common.Node
import java.util.*

fun main() {
    val node = Node(4.0).also {
        it.left = Node(2.0).also {
            it.left = Node(1.0)
            it.right = Node(3.0)
        }
        it.right = Node(5.0)
    }
    println(closestInBST(node, 3.714286))

}

fun closestInBST(node: Node<Double>?, number: Double): Double? {
    if (node == null)
        return null
    var ceil: Double? = null
    var floor: Double? = null
    val stack = Stack<Node<Double>>()
    stack.push(node)

    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        if (pop.value!! <= number && (pop.value!! >= (floor ?: Double.MIN_VALUE)))
            floor = pop.value!!
        if (pop.value!! >= number && (pop.value!! <= (ceil ?: Double.MAX_VALUE)))
            ceil = pop.value!!

        if (pop.value!! > number) {
            if (pop.left == null)
                break
            stack.push(pop.left)
        }
        if (pop.value!! < number) {
            if (pop.right == null)
                break
            stack.push(pop.right)
        }
    }
    if (((floor ?: Double.MIN_VALUE) + (ceil ?: Double.MAX_VALUE)) / 2 > number)
        return floor
    else
        return ceil
}
