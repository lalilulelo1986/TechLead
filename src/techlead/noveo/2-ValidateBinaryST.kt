package techlead.noveo

import techlead.common.Node
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    val rootNode = Node(2).also {
        it.left = Node(1)
        it.right = Node(3)
    }
    assertTrue { isValidBST(rootNode) }

    val rootNode2 = Node(5).also {
        it.left = Node(1)
        it.right = Node(4).also {
            it.left = Node(3)
            it.right = Node(6)
        }
    }
    assertFalse { isValidBST(rootNode2) }
}

fun isValidBST(root: Node<Int>?, min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE): Boolean {
    if (root == null)
        return true
    return (root.value!! in min..max && isValidBST(root.left, min, root.value!!) && isValidBST(root.right, root.value!!, max))
}