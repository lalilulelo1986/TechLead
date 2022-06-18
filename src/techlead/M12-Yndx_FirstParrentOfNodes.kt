package techlead

import techlead.common.Node

fun main() {
    val node1 = Node(10)
    val node2 = Node(11)
    val tree = Node(1).also { a ->
        a.left = Node(2).also { b ->
            b.parent = a
            b.left = Node(4).also { x ->
                x.parent = b
                x.left = node2.also { it.parent = x }
            }
            b.right = Node(5).also { y ->
                y.parent = b
                y.left = node1.also { it.parent = y }
            }
        }
        a.right = Node(3).also { c ->
            c.parent = a
            c.left = Node(6)
            c.right = Node(7)
        }
    }
    println(findFirstParrent(node1, node2))
}

fun <T> findFirstParrent(node1: Node<T>, node2: Node<T>): Node<T>? {
    if (node1 == node2) {
        if (node1.parent != null)
            return node1.parent
        return null
    }

    var node1Length = 0
    var node2Length = 0
    var curNode1: Node<T>? = node1
    var curNode2: Node<T>? = node2
    while (curNode1 != curNode2) {
        if (curNode1?.parent != null) {
            node1Length++
            curNode1 = curNode1.parent
        }
        if (curNode2?.parent != null) {
            node2Length++
            curNode2 = curNode2.parent
        }
    }

    if (node1Length == node2Length) {
        return curNode1
    } else {
        curNode1 = node1
        curNode2 = node1
        while (curNode1 != curNode2) {
            if (node1Length > node2Length) {
                node1Length--
                curNode1 = curNode1?.parent
            } else if (node1Length < node2Length) {
                node2Length--
                curNode2 = curNode2?.parent
            } else {
                curNode1 = curNode1?.parent
                curNode2 = curNode2?.parent
            }
        }
        return curNode1
    }
}