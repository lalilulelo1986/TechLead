package techlead.common

class Tree<T>(
    var value: T,
    var children: MutableList<Tree<T>> = mutableListOf()
) {
    override fun toString(): String {
        return "Tree(value=$value, children=$children)"
    }
}