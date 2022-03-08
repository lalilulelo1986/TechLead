package techlead

import techlead.common.factorial
import java.time.Instant
import java.util.*
import kotlin.collections.HashMap

fun main() {
//    var counter = 1
//    val toIntArray = generateSequence { counter.takeIf { ++counter <= 12 } }.toList()
//    println(toIntArray)
//    val epochSecond = Instant.now().epochSecond
//    Permutation(toIntArray).printAllPermutations()
//    println(Instant.now().epochSecond - epochSecond) // 17 185

//    val array = arrayOf(1, 2, 3)
//    val permutation2 = Permutation2()
//    val epochSecond2 = Instant.now().epochSecond
//    permutation2.permute(array)
//    println(Instant.now().epochSecond - epochSecond2) // 14 166
//    println(permutation2.result.size)
//    permutation2.result.forEach { println(it.toList()) }

//    PermCutting().perm(mutableListOf(1, 2, 3), mutableListOf())
    Permutation2().permute(arrayOf(1, 2, 3), 0)
}

// HashMap SHIT
class Permutation(val array: List<Int>) {
    private val length = array.size
    private val hashMap = HashMap<Int, Int>(length)

    fun printAllPermutations() {
        helper(0)
    }

    private fun helper(pointer: Int) {
        if (pointer + 1 > length) {
//            println(hashMap)
            return
        }

        for (i in array.indices) {
            if (hashMap[i] == null) {
                hashMap[i] = array[pointer]
                helper(pointer + 1)
                hashMap.remove(i)
            }
        }
    }
}

// Swap
class Permutation2 {
    val result = arrayListOf<Array<Int>>()

    fun permute(array: Array<Int>, start: Int = 0) {


        if (start == array.size - 1) {
            result.add(array.copyOf())
            println(array.toList())
        }
        for (i in start until array.size) {
            array[start] = array[i].also { array[i] = array[start] }
            permute(array, start + 1)
            array[i] = array[start].also { array[start] = array[i] }
        }
    }
}

// Cutting
class PermCutting {

    fun perm(array: MutableList<Int>, values: MutableList<Int>) {
        println(array)
        if (array.size == 0) {
            println("result: $values")
        }

        for (i in array.indices) {
            perm(
                (array.take(i) + array.takeLast(array.size - 1 - i)).toMutableList(),
                (values + mutableListOf(array[i])).toMutableList()
            )
        }
    }
}