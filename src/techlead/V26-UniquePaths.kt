package techlead

/**
 * Can go left or down. Find all possible paths
 * */
fun main() {
//    println(uniquePaths(4, 2) + 1)
    println(uniquePaths2(5, 3))
}


// My Solution
fun uniquePaths(x: Int, y: Int): Int {
    if (x > 0 && y > 0)
        return 1 + uniquePaths(x - 1, y) + uniquePaths(x, y - 1)
    return 0
}

// First
fun uniquePaths2(x: Int, y: Int): Int {
    return if (x == 1 || y == 1)
        1
    else
        uniquePaths2(x - 1, y) + uniquePaths2(x, y - 1)
}

// With Cache Precomputed
//fun uniquePaths3(x: Int, y: Int): Int {
//
//}