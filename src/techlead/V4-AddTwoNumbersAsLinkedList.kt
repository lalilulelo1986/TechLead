package techlead

/**
 * 125 + 481 = 606
 */

data class LinkedNode<T>(
    var value: T,
    var next: LinkedNode<T>? = null
)

fun main() {
    val list1 = LinkedNode(6).also { it.next = LinkedNode(4).also { it.next = LinkedNode(2) } }
    val list2 = LinkedNode(3).also { it.next = LinkedNode(7).also { it.next = LinkedNode(2) } }
    println("Result list: ${addLists(list1, list2)}")
}

// Solution with isMind: Boolean
fun addLists(list1: LinkedNode<Int>?, list2: LinkedNode<Int>?): LinkedNode<Int>? {
    var result: LinkedNode<Int>? = null

    var resultPointer: LinkedNode<Int>? = null
    var list1Pointer = list1
    var list2Pointer = list2
    var isMind = false

    while (list1Pointer != null || list2Pointer != null) {
        resultPointer?.next?.let { resultPointer = it }

        val sum = (list1Pointer?.value?.plus(list2Pointer?.value ?: 0))
        sum?.let {
            if (resultPointer == null) {
                resultPointer = LinkedNode(sum.rem(10))
                result = resultPointer
                isMind = sum / 10 >= 1
                if (isMind) {
                    resultPointer?.let { it.next = LinkedNode((sum) / 10) }
                }
                return@let
            }

            if (isMind) {
                isMind = (resultPointer!!.value + sum) / 10 >= 1
                if (isMind)
                    resultPointer!!.next = LinkedNode((resultPointer!!.value + sum) / 10)
                resultPointer!!.value = (resultPointer!!.value + sum).rem(10)
            } else {
                resultPointer!!.next = LinkedNode(sum.rem(10))
                resultPointer = resultPointer?.next // we need to move 1
                isMind = sum / 10 >= 1
                if (isMind) {
                    resultPointer!!.next = LinkedNode((sum) / 10)
                }
            }
        }

        list1Pointer = list1Pointer?.next
        list2Pointer = list2Pointer?.next
    }

    return result
}

// Solution with inMind: Int TODO need to finish
fun addLists2(list1: LinkedNode<Int>?, list2: LinkedNode<Int>?): LinkedNode<Int>? {
    var result: LinkedNode<Int>? = null
    var inMind = 0
    var list1Pointer = list1
    var list2Pointer = list2

    while (list1Pointer != null || list2Pointer != null) {
        val sum = (list1Pointer?.value?.plus(list2Pointer?.value ?: 0))
        sum?.let {
            inMind = sum.rem(10)
            if (result == null) {
                result = LinkedNode(sum.rem(10))
                if (inMind > 0) {
                    result!!.next = LinkedNode((sum) / 10)
                }
                return@let
            }

            if (result != null) {

            }
        }
    }

    return result
}