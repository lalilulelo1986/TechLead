package geek.problem.diameterbinarytree.concurr

import java.lang.Thread.sleep
import java.util.*

class WaitVsBlocked {
    //    private val lock = java.lang.Object()
//    @Synchronized
    fun joina(thread: Thread) {
        synchronized(thread) {
            println("Joining on thread: ${thread.name}")
            thread.join()//
//        (this as Object).wait()
            println("Released on ${thread.name}")
        }

    }

    @Synchronized
    fun notifyAll1() {
//        thread.join()//
        (this as Object).notifyAll()
    }

    companion object {

    }
}

fun main() {
    val waitVsBlocked = WaitVsBlocked()
    val longThread = Thread {
        println("Starting longThread thread: ${Thread.currentThread().name}")
        sleep(10000)
    }.also { it.start() }
    for (j in 1..10) {
        val thread = Thread {
            println("Starting fast thread: ${Thread.currentThread().name}")
            waitVsBlocked.joina(longThread)
        }.also { it.start() }
    }
    longThread.join()
//    waitVsBlocked.notifyAll1()
}