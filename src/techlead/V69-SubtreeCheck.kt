package techlead

import techlead.common.Node

fun isSubTree(node1: Node<Int>?, node2: Node<Int>?): Boolean {
//    println("${node1?.value} - ${node2?.value}")
//    println("${node1?.value == node2?.value}")
    if (node1?.value == node2?.value) {
        val leftMatch = node2?.left == null || isSubTree(node1?.left, node2.left)
        if (leftMatch) {
            val rightMatch = node2?.right == null || isSubTree(node1?.right, node2.right)
            if (rightMatch)
                return true
        }
//        return false
    }
    if (node1?.value != null && node2?.value != null)
        return isSubTree(node1.left, node2) || isSubTree(node1.right, node2)
    return false
}

fun isSubTree2(a: Node<Int>?, b: Node<Int>?, inside: Boolean = false): Boolean {
    if (a?.value == null)
        return false

    var localInside = inside
    var left: Boolean? = null
    var right: Boolean? = null
    if (a.value == b?.value) {
        localInside = true
        left = (a.left == null && b?.left == null) || isSubTree2(a.left, b?.left, true)
        right = (a.right == null && b?.right == null) || isSubTree2(a.right, b?.right, true)
    }

    if (localInside)
        return b?.value == null || left == true && right == true

    return isSubTree2(a.left, b, false) || isSubTree2(a.right, b, false)
}

fun main() {
    val a = Node(1).also {
        it.left = Node(4).also {
            it.left = Node(3)
            it.right = Node(2)
        }
        it.right = Node(5).also {
            it.left = Node(4)
            it.right = Node(1)
        }
    }
    val b = Node(4).also {
        it.left = Node(3)
        it.right = Node(2)
    }
    println(isSubTree2(a, b))

    val a2 = Node(3).also {
        it.left = Node(4).also {
            it.left = Node(1)
            it.right = Node(2).also {
                it.left = Node(0)
            }
        }
        it.right = Node(4).also {
            it.left = Node(1)
            it.right = Node(2)
        }
    }
    val b2 = Node(4).also {
        it.left = Node(1)
    }
    println(isSubTree2(a2, b2))

    val a3 = Node(3).also {
        it.left = Node(4).also {
            it.left = Node(1)
            it.right = Node(2).also {
                it.left = Node(0)
            }
        }
        it.right = Node(4).also {
            it.left = Node(1)
            it.right = Node(2)
        }
    }
    val b3 = Node(4)
    println(isSubTree2(a3, b3))
}

//def find_subtree2(a, b):
//  if not a:
//    return False
//
//  is_match = a.value == b.value
//  if is_match:
//    is_match_left = (not a.left or not b.left) or find_subtree2(a.left, b.left)
//    if is_match_left:
//      is_match_right = (not a.right or not b.right) or find_subtree2(
//          a.right, b.right)
//      if is_match_right:
//        return True
//
//  return find_subtree2(a.left, b) or find_subtree2(a.right, b)
//
//
//print(find_subtree(n, b))
//# True
//
//print(find_subtree2(n, b))
//# True