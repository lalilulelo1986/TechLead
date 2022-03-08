package techlead

import techlead.common.Node

var isValid = true

fun main() {
    val root = Node(5).also {
        it.left = Node(1).also {
            it.left = Node(0)
        }
        it.right = Node(6).also {
            it.left = Node(4)
        }
    }

//    validateTree(root)
    // 0
    println("isValid: $isValid")

    println("validateTree2: ${validateTree2(root)}")
}

// Solution 1
//fun validateTree(node: Node<Int>): Int {
//    if (!isValid)
//        return 0
//
//    val maxLeft = if (node.left == null) Int.MIN_VALUE else validateTree(node.left!!)
//    val minRight = if (node.right == null) Int.MAX_VALUE else validateTree(node.right!!)
//
//    if (maxLeft > node.value!! || minRight < node.value!!) {
//        isValid = false
//        println("$maxLeft > ${node.value} $minRight < ${node.value}")
//        return 0
//    } else {
//        return node.right?.value ?: node.value!!
//    }
//}

// Solution 2
fun validateTree2(node: Node<Int>): Boolean {
    return validateHelper(node, Int.MIN_VALUE, Int.MAX_VALUE)
}

fun validateHelper(node: Node<Int>?, min: Int, max: Int): Boolean {
    if (node == null)
        return true

    return (node.value ?: Int.MAX_VALUE) > min && (node.value ?: Int.MIN_VALUE) < max &&
        validateHelper(node.left, min, node.value!!) &&
        validateHelper(node.right, node.value!!, max)
}