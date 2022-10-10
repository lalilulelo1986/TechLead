package geek.problem.generic.bound

import java.util.Objects

class App {
}

fun main() {
    foo()
}

interface Source2<out T> {
    fun nextT(): T
}

fun demo(strs: Source2<String>) {
    val objects: Source2<Any> = strs // This is OK, since T is an out-parameter
    // ...
}

fun foo() {
    val list: MutableList<Number> = mutableListOf(1)
    list.add(3.3)
    list.forEach {
        println(it)
    }
}

fun copy(from: Array<Any>, to: Array<Any>) {
    val list: MutableList<Number> = mutableListOf(1)
    list.add(3.3)

    assert(from.size == to.size)
//    for (i in from.indices)
//        to[i] = from[i]
}