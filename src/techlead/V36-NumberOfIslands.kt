package techlead

//grid = [[1, 1, 0, 0, 0],
//        [0, 1, 0, 0, 1],
//        [1, 0, 0, 1, 1],
//        [0, 0, 0, 0, 0]]
fun main() {
    val grid = arrayOf(
        arrayOf(1, 1, 0, 0, 0),
        arrayOf(0, 1, 0, 0, 1),
        arrayOf(1, 0, 0, 1, 1),
        arrayOf(0, 0, 0, 0, 0),
    )
    println(numberOfIslands(grid))
}

fun numberOfIslands(grid: Array<Array<Int>>): Int {
    var islands = 0
    val visited = HashMap<Int, Int>()

    for (y in grid.indices) {
        for (x in grid[y].indices) {
            val index = (y * grid[y].size) + x
            if (grid[y][x] == 1 && visited[index] == null) {
                walker(grid, y, x, visited)
                islands++
            }
        }
    }

    return islands
}

fun walker(grid: Array<Array<Int>>, y: Int, x: Int, visited: HashMap<Int, Int>) {
    if (y in grid.indices && x in grid[y].indices && grid[y][x] == 1 && visited[(y * grid[y].size) + x] != 1) {
        val index = (y * grid[y].size) + x
        visited[index] = 1
        walker(grid, y + 1, x, visited)
        walker(grid, y - 1, x, visited)
        walker(grid, y, x + 1, visited)
        walker(grid, y, x - 1, visited)
    }
}

