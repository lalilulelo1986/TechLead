package techlead

import java.util.*

/*
    /users/tech/docs/.././desk/../ => /users/tech/
 */
fun main() {
    println(absolutePath("/users/tech/docs/.././desk/../"))
}

// My stack
fun absolutePath(path: String): String {
    val stack = Stack<String>()
    path.split("/").forEach {
        when (it) {
            ".." -> {
                stack.pop()
            }
            "." -> {}
            else -> {
                stack.push(it)
            }
        }
    }
    return stack.joinToString("/")
}