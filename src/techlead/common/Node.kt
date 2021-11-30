package techlead.common

class Node<T>(
    var value: T,
    var left: Node<T>? = null,
    var right: Node<T>? = null
) {
    override fun toString(): String {
        return "Node(value=$value, left=$left, right=$right)"
    }
}

fun generateNode(values: Array<Int>): Node<Int>? {
    return null
}