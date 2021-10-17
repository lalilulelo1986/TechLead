package techlead

fun main() {
    var arr = arrayOf(
        arrayOf(1, 2, 3, 4, 5),
        arrayOf(6, 7, 8, 9, 10),
        arrayOf(11, 12, 13, 14, 15),
        arrayOf(16, 17, 18, 19, 20),
    )
    val path = buildPath(4, 5)
    println(path.toSortedMap())
    val result = arrayOfNulls<Int?>(20)
    for (x in arr.indices) {
        for (y in arr[x].indices) {
            result[path["${x},${y}"]!!] = arr[x][y]
        }
    }
    result.forEach { print("$it,") }
}

fun buildPath(xSize: Int, ySize: Int): HashMap<String, Int> {
    val path = HashMap<String, Int>(xSize * ySize)
    var count = 0
    var road = 0
    var x = 0
    var y = 0
    while (count < xSize * ySize) {
        path["${x},${y}"] = count
        when (road.mod(4)) {
            0 -> if (y + 1 in (0 until ySize) && path["${x},${y + 1}"] == null) {
                y++; count++
            } else {
                x++; road++; count++
            }
            1 -> if (x + 1 in (0 until xSize) && path["${x + 1},${y}"] == null) {
                x++; count++
            } else {
                y--; road++; count++
            }
            2 -> if (y - 1 in (0 until ySize) && path["${x},${y - 1}"] == null) {
                y--; count++
            } else {
                x--; road++; count++
            }
            3 -> if (x - 1 in (0 until xSize) && path["${x - 1},${y}"] == null) {
                x--; count++
            } else {
                y++; road++; count++
            }
        }
    }
    return path
}