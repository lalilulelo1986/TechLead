package geek.problem.concurr

import java.lang.RuntimeException
import java.lang.Thread.sleep

fun main() {
    val also = Thread {
        println("Starting child thread")
        throw Exception("fuck")
    }.also { it.start() }

    for (i in 1..100) {
        println("doing i: $i")
        also.join()
    }
}