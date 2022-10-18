package techlead.noveo

import kotlin.test.assertEquals

fun main() {
    val array = arrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1).toIntArray()
    assertEquals(6, trap(array))
}

fun trap(height: IntArray): Int {
    val maxHeight = height.maxOrNull() ?: return 0

    var result = 0
    for (h in 1..maxHeight) {
        var inside = false
        var localSize = 0
        for (l in height) {
            if (l >= h && inside.not()) {
                inside = true
                localSize = 0
                continue
            }

            if (l < h)
                localSize++

            if (l >= h && localSize > 0 && inside) {
                result += localSize
                localSize = 0
            }
        }
    }

    return result
}