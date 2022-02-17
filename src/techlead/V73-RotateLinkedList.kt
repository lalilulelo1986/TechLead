package techlead

fun main() {
    val links = LinkedNode(1).also {
        it.next = LinkedNode(2).also {
            it.next = LinkedNode(3).also {
                it.next = LinkedNode(4).also {
                    it.next = LinkedNode(5)
                }
            }
        }
    }
    println(rotateLinked(links, 3))
//    println(rotateLinked(links, 2))
//    println(rotateLinked(links, 3))
//    println(rotateLinked(links, 4))
}

fun rotateLinked(node: LinkedNode<Int>?, rotates: Int): LinkedNode<Int>? {
    var length = 0
    var curr = node
    while (curr != null) {
        length++
        curr = curr.next
    }

    val offset = rotates.mod(length)
    if (offset == 0)
        return node

    var slow = node
    var fast = node
    for (i in 1 until length) {
        fast = fast?.next
        if (i > offset)
            slow = slow?.next
    }

    val head = slow?.next
    slow?.next = null
    fast?.next = node
    return head
}

//class Node:
//    def __init__(self, value, next=None):
//self.value = value
//self.next = next
//
//def __repr__(self):
//return f"({self.value}, {self.next})"
//
//def rotate(node, n):
//  length = 0
//  curr = node
//  while curr != None:
//    curr = curr.next
//    length +=1
//  n = n % length
//
//  slow, fast = node, node
//  for i in range(n):
//    fast = fast.next
//
//  while fast.next != None:
//    slow = slow.next
//    fast = fast.next
//
//  fast.next = node
//  head = slow.next
//  slow.next = None
//
//  return head
//
//node = Node(1, Node(2, Node(3, Node(4, Node(5)))))
//
//print(rotate(node, 2))
//# 4, 5, 1, 2, 3
