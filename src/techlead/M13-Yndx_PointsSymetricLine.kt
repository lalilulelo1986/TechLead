package techlead

import kotlin.math.abs

fun main() {
//    val points = listOf(1 to 1, 2 to 1)
//    println(findSymetricLine(points))
    val points2 = listOf(
        0 to 3, 1 to 2, 3 to 1, 4 to 3,
        0 to 6, 1 to 4, 3 to 5, 4 to 6
    )

    val points3 = listOf(
        1 to 1, 3 to 3, 5 to 2, 6 to 3,
        -2 to 2, -3 to 3, -4 to 1, -6 to 3
    )
    println(findSymetricLine(points3))
    val points4 = listOf(
        -5 to 3, -5 to -3, -4 to 1, -3 to 3, -2 to 0, -1 to 3, 0 to 1, 1 to 3, 1 to -3
    )
    println(findSymetricLine(points4))
}

fun findSymetricLine(points: List<Pair<Int, Int>>): Double? {
    if (points.isEmpty())
        return null

    var mostLeftX = Int.MAX_VALUE
    var mostRightX = Int.MIN_VALUE
    points.forEach { (x, _) ->
        if (x * 2 < mostLeftX)
            mostLeftX = x * 2
        if (x * 2 > mostRightX)
            mostRightX = x * 2
    }

    if (mostLeftX == mostRightX)
        return mostLeftX / 2.0

    val symetric = (mostLeftX + mostRightX) / 2
    var vectorX = symetric
    var vectorY = 0
    var xoredX = 0
    var xoredY = 0
    points.forEach { (x, y) ->
        if (x * 2 != symetric) {
            vectorX += x * 2 - symetric
            vectorY += if (x * 2 > symetric) y else -y

            xoredX = xoredX xor abs(x * 2 - symetric)
            xoredY = xoredY xor y
        }
    }
    println("xorX: $xoredX xorY: $xoredY")
    println("vectorX: ${vectorX / 2.0} vectorY: ${vectorY / 2.0}")

    return if (xoredX == 0 && xoredY == 0 && vectorX == symetric && vectorY == 0)
        symetric / 2.0
    else null
}