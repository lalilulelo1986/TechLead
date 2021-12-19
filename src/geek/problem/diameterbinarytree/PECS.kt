package geek.problem.diameterbinarytree

import java.util.function.Function

interface Source<T> {
    fun nextT(): T
}

fun main() {
    println("OK")
    val f: Function<Number, Int> = Function<Number, Int> { 3 }
    val f2: Function<Number, CharSequence> = Function<Number, CharSequence> { it.toString() }
    val f3 = f.andThen(f2)
    listOf(1, 2).map { f3.apply(it) }.forEach {
        println(it)
    }
}

fun demo(strs: Source<String>) {
    val objects: Source<out Any> = strs // This is OK, since T is an out-parameter
    // ...
    arrayListOf(1, 3, 4).map { v -> v }
}

fun callCopy() {
    copy(mutableListOf(1, 2, 3), MutableList(3) {})
}

fun copy(from: MutableList<out Any>, to: MutableList<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}