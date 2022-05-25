package geek.problem.diameterbinarytree

fun main() {
    val arr = arrayOf(1, 2, 3, 4)
    var i = 0

    arr.forEach {
        i++
        println(it)
//        return
    }
    println("END: $i")

    val sum: Int.(Int) -> Int = { other -> this.plus(other) }
    val sum2 = fun Int.(other: Int): Int = this + other

    Integer.valueOf(1).sum(1).apply {

    }
}

fun Int.sum(other: Int) = plus(other)