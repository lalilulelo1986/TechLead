package geek.problem

class Logger(val name: String) {
    fun log(s: String) {
        println("$name: $s")
    }
}

//context(Logger)
//fun store(s: String) {
//    log("Stored")
//}

class Api {
    fun get(): String = "Hello, World"
}

fun main() {
    val logger = Logger("Main")
    with(logger) {
        with(Api()) {
            log(get())
        }
    }
}