package techlead

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val list1 = LinkedNode(3)
        .also {
            it.next = LinkedNode(1)
                .also {
                    it.next = LinkedNode(2).also {
                        it.next = LinkedNode(-1).also {
                            it.next = LinkedNode(-2).also { it.next = LinkedNode(4).also { it.next = LinkedNode(1) } }
                        }
                    }
                }
        }

    println(remuveSubZeroLists(list1))
}

// TechSolution
fun remuveSubZeroLists(linkedNode: LinkedNode<Int>): LinkedNode<Int>? {
    val map = HashMap<Int, LinkedNode<Int>>()
    val stack = Stack<Int>()
    var sum = 0
    val dammy = LinkedNode(0)
    dammy.next = linkedNode
    var n: LinkedNode<Int>? = dammy
    while (n != null) {
        sum += n.value
        if (map[sum] == null) {
            map[sum] = n
            stack.push(sum)
        } else {
            val prev = map[sum]
            prev?.next = n.next
            while (stack.peek() != sum) {
                map.remove(stack.pop())
            }
        }
        n = n.next
    }
    return dammy.next
}