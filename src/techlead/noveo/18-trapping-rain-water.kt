package techlead.noveo

import kotlin.test.assertEquals

fun main() {
    val array = arrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1).toIntArray()
    assertEquals(6, trap(array))

    val array2 = arrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1).toIntArray()
    println(trap2(array2))
}

fun trap(height: IntArray): Int {
    val maxHeight = height.maxOrNull() ?: return 0

    var result = 0
    for (h in 1..maxHeight) {
        var inside = false
        var localSize = 0
        for (l in height) {
            if (l < h && inside)
                localSize++

            if (l >= h && inside.not())
                inside = true

            if (l >= h && localSize > 0 && inside)
                result += localSize.also { localSize = 0 }
        }
    }

    return result
}

// линейное время. конст. память
fun trap2(height: IntArray): Int {
    val maxIndex = height.maxOrNull()?.let { height.indexOf(it) } ?: -1

    var max = 0
    var size = 0
    for (i in 0..maxIndex) {
        if (max > height[i])
            size += max - height[i]
        if (height[i] > max)
            max = height[i]
    }
    max = 0
    for (i in height.size - 1 downTo maxIndex) {
        if (max > height[i])
            size += max - height[i]
        if (height[i] > max)
            max = height[i]
    }
    return size
}