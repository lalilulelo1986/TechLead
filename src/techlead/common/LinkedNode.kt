package techlead.common

data class LinkedNode<T>(
    var value: T,
    var next: LinkedNode<T>? = null
) {
    fun append(node: LinkedNode<T>): LinkedNode<T> {
        this.next = node
        return node
    }

    override fun toString(): String {
        return "$value, ${next ?: ""}"
    }
}