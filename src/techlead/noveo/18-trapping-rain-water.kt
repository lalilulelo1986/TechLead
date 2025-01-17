package techlead.noveo

import kotlin.test.assertEquals

fun main() {
    // квадратич
    val array = arrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1).toIntArray()
    assertEquals(6, trap(array))

    // линейн
    val array2 = arrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1).toIntArray()
    assertEquals(6, trap2(array2))
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
    if (height.isEmpty())
        return 0
    var maxHeightIndex = 0
    var maxHeight = 0
    height.forEachIndexed { index, i ->
        if (i > maxHeight) {
            maxHeight = i
            maxHeightIndex = index
        }
    }

    var currMaxHeight = 0
    var result = 0
    for (i in 0..maxHeightIndex) {
        if (currMaxHeight > height[i])
            result += currMaxHeight - height[i]
        if (height[i] > currMaxHeight)
            currMaxHeight = height[i]
    }
    currMaxHeight = 0
    for (i in height.size - 1 downTo maxHeightIndex) {
        if (currMaxHeight > height[i])
            result += currMaxHeight - height[i]
        if (height[i] > currMaxHeight)
            currMaxHeight = height[i]
    }
    return result
}