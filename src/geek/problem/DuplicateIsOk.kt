package geek.problem

class SomeData(val value: Int) {
    override fun equals(other: Any?): Boolean {
        return value == (other as SomeData).value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}

fun main() {
    val set = HashSet<SomeData>()
    if (!set.add(SomeData(1))) {
        println("duplicate")
    }
    if (!set.add(SomeData(2))) {
        println("duplicate")
    }
    if (!set.add(SomeData(2))) {
        println("duplicate")
    }
    println(set.size)

    val set2 = HashSet<Int>()
    if (!set2.add(1)) {
        println("duplicate")
    }
    if (!set2.add(2)) {
        println("duplicate")
    }
    if (!set2.add(2)) {
        println("duplicate")
    }
    println(set2.size)
}