package techlead.common

import java.util.*

class Stack {
    val linkedList = LinkedList<Int>()
    val maxes = LinkedList<Int>()

    fun push(value: Int) {
        linkedList.add(value)
        if (maxes.lastOrNull() == null || value > maxes.lastOrNull()!!) {
            maxes.add(value)
        } else {
            maxes.add(maxes.last())
        }
    }

    fun pop(): Int {
        maxes.removeLast()
        return linkedList.removeLast()
    }

    fun getMax(): Int? {
        return maxes.lastOrNull()
    }

    override fun toString(): String {
        return linkedList.toString()
    }
}