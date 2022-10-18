package techlead.noveo

import java.util.Stack

fun main() {
    val s1 = "()"
    println(isValid(s1))
    val s2 = "()[]{}"
    println(isValid(s2))
    val s3 = "(]"
    println(isValid(s3))
}

val pairs = mapOf(']' to '[', ')' to '(', '}' to '{')
fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    s.forEach { c ->
        if (pairs[c] == if (stack.isNotEmpty()) stack.peek() else Any())
            stack.pop()
        else
            stack.add(c)
    }
    return stack.isEmpty()
}

val allowedChars = setOf('[', ']', '(', ')', '{', '}')
fun isValid2(s: String): Boolean {
    val stack = Stack<Char>()
    s.forEach { c ->
        if (allowedChars.contains(c).not())
            return false
        if (stack.isEmpty()) {
            if (pairs[c] != null)
                return false
            else
                stack.add(c)
        } else {
            val peek = stack.peek()
            if (pairs[c] == peek)
                stack.pop()
            else
                return false
        }
    }

    return stack.isEmpty()
}