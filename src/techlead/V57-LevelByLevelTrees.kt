package techlead

import techlead.common.Tree
import java.util.*

fun main() {
    val tree = Tree(
        "a", mutableListOf(
            Tree("b"),
            Tree(
                "c", mutableListOf(
                    Tree("d"), Tree("e"), Tree("f")
                )
            )
        )
    )
    levelByLevel(tree)
    levelByLevel2(tree)
}

// My
fun <T> levelByLevel(tree: Tree<T>) {
    val queue: Queue<Pair<Tree<T>, Int>> = ArrayDeque()
    queue.add(tree to 1)
    var prevLevel = 1

    while (queue.isNotEmpty()) {
        queue.poll().also { polled ->
            if (polled.second != prevLevel) {
                println()
                prevLevel = polled.second
            }
            print(polled.first.value)
            polled.first.children.forEach { queue.add(it to polled.second + 1) }
        }
    }
    println()
}

// TechLead
fun <T> levelByLevel2(tree: Tree<T>) {
    val queue: Queue<Pair<Tree<T>, Int>> = ArrayDeque()
    queue.add(tree to 1)

    while (queue.isNotEmpty()) {
        var len = queue.size
        while (len > 0) {
            queue.poll().also { polled ->
                len -= 1
                print(polled.first.value)
                polled.first.children.forEach { queue.add(it to polled.second + 1) }
            }
        }
        println()
    }
}