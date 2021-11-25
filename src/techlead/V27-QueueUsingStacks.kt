package techlead

import java.util.*

fun main() {
    val queueMy = QueueMy<Int>()
    queueMy.push(1)
    queueMy.push(2)
    queueMy.push(3)
    queueMy.push(4)
    println(queueMy.pop())
    queueMy.push(5)
    queueMy.push(6)
    println(queueMy.pop())
}

class QueueMy<T> {
    private val pushStack = Stack<T>()
    private val popStack = Stack<T>()

    fun push(value: T) {
        pushStack.push(value)
    }

    fun pop(): T {
        if (popStack.isEmpty())
            for (v in 1..pushStack.size)
                popStack.push(pushStack.pop())
        return popStack.pop()
    }
}