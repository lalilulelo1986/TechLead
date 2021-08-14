package techlead

import techlead.common.Stack

fun main() {
    val stack = Stack()
    stack.push(1)
    stack.push(4)
    stack.push(3)
    stack.push(2)
    stack.push(-1)
    println(stack)
    println(stack.getMax())
    stack.pop()
    println(stack.getMax())
    stack.pop()
    println(stack.getMax())
    stack.pop()
    println(stack.getMax())
    stack.pop()
    println(stack.getMax())
}