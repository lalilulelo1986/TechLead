package techlead

import java.util.*

fun main() {
    val parentheses = mapOf(
        '(' to ')',
        '{' to '}',
        '[' to ']'
    )
    println(MySolution22.validateParentheses("([]){}{}", parentheses))
    println(MySolution22.validateParentheses("([]){}{", parentheses))
    println(MySolution22.validateParentheses("([]){}{)", parentheses))
    println(MySolution22.validateParentheses("(){([])}", parentheses))
    println(MySolution22.validateParentheses("(){([", parentheses))
}

class MySolution22 {
    companion object {
        fun validateParentheses(str: String, parentheses: Map<Char, Char>): Boolean {
            val stack = Stack<Char>()
            str.forEach { nextChar ->
                if (nextChar in parentheses.keys) {
                    stack.push(nextChar)
                } else {
                    val prev = stack.takeIf { it.isNotEmpty() }?.peek() ?: return false
                    if (parentheses[prev] == nextChar) {
                        stack.pop()
                    } else {
                        return false
                    }
                }
            }

            return stack.isEmpty()
        }
    }
}