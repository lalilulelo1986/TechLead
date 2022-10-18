package techlead.noveo

import techlead.LinkedNode
import kotlin.test.assertEquals

fun main() {
    // case 1
    val l1 = LinkedNode(2).also { it.next = LinkedNode(4).also { it.next = LinkedNode(3) } }
    val l2 = LinkedNode(5).also { it.next = LinkedNode(6).also { it.next = LinkedNode(4) } }
    val result1 = addTwoNumbers(l1, l2)
    assertEquals(7, result1!!.value)
    assertEquals(0, result1!!.next!!.value)
    assertEquals(8, result1!!.next!!.next!!.value)

    // case 2
    val l11 = LinkedNode(0)
    val l22 = LinkedNode(0)
    val result2 = addTwoNumbers(l11, l22)
    assertEquals(0, result2!!.value)

    // case 3
    val l111 =
        LinkedNode(9).also {
            it.next = LinkedNode(9).also {
                it.next = LinkedNode(9).also {
                    it.next = LinkedNode(9).also {
                        it.next = LinkedNode(9).also { it.next = LinkedNode(9).also { it.next = LinkedNode(9) } }
                    }
                }
            }
        }
    val l222 =
        LinkedNode(9).also { it.next = LinkedNode(9).also { it.next = LinkedNode(9).also { it.next = LinkedNode(9) } } }
    val result3 = addTwoNumbers(l111, l222)
    println(l111)
    println(l222)
    println(result3)
    assertEquals(8, result3!!.value)
    assertEquals(9, result3!!.next!!.value)
    assertEquals(9, result3!!.next!!.next!!.value)
    assertEquals(9, result3!!.next!!.next!!.next!!.value)
    assertEquals(0, result3!!.next!!.next!!.next!!.next!!.value)
    assertEquals(0, result3!!.next!!.next!!.next!!.next!!.next!!.value)
    assertEquals(0, result3!!.next!!.next!!.next!!.next!!.next!!.next!!.value)
    assertEquals(1, result3!!.next!!.next!!.next!!.next!!.next!!.next!!.next!!.value)
}

fun addTwoNumbers(l1: LinkedNode<Int>?, l2: LinkedNode<Int>?): LinkedNode<Int>? {
    var curL1 = l1
    var curL2 = l2
    val result = LinkedNode(0)
    var currResult = result

    var inMind = 0
    while (curL1 != null || curL2 != null) {
        val sum = (curL1?.value ?: 0) + (curL2?.value ?: 0) + inMind
        inMind = if (sum > 9) 1 else 0
        currResult.next = LinkedNode(sum.mod(10))
        currResult = currResult.next!!
        curL1?.let { curL1 = it.next }
        curL2?.let { curL2 = it.next }
    }
    if (inMind == 1)
        currResult.next = LinkedNode(inMind)

    return result.next
}