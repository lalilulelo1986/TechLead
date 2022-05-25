package techlead

import java.util.*

data class Box(
    val length: Int,
    val weight: Int,
    val height: Int
) : Comparable<Box> {
    override fun compareTo(other: Box): Int {
        val length = this.length - other.length
        val weight = this.weight - other.weight
        return if (length > 0 && weight > 0) {
            1
        } else if (length < 0 && weight < 0)
            -1
        else
            0
    }
}

fun main() {
    val boxes = arrayOf(
        Box(2, 4, 1),
        Box(2, 3, 2),
        Box(1, 2, 2),
        Box(4, 5, 3),
        Box(1, 5, 4),
        Box(3, 6, 2),
    )
    println(largestHeight(boxes))
}

fun largestHeight(boxes: Array<Box>): Int? {
    Arrays.sort(boxes)
    val heightList = boxes.map { it.height }.toTypedArray()
    for (i in 1 until boxes.size)
        for (k in 0 until i)
            if (boxes[i] > boxes[k])
                heightList[i] = maxOf<Int>(heightList[i], heightList[k] + boxes[i].height)
    return heightList.maxOrNull()
}