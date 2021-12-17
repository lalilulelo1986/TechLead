package techlead

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max

// like bigest island
fun main() {
    val grid = arrayOf(
        arrayOf(1, 0, 1, 0),
        arrayOf(0, 1, 1, 1),
        arrayOf(0, 1, 0, 0),
    )
    println(maxConnected(grid))
    println(maxConnectedBFS(grid))
    println(maxConnectedDFS(grid))
}

// My iterative
fun maxConnected(grid: Array<Array<Int>>): Int {
    var maxConected = 0
    val visited = HashMap<Int, Int>()

    for (y in grid.indices) {
        for (x in grid[y].indices) {
            val index = (y * grid[y].size) + x
            if (grid[y][x] == 1 && visited[index] == null) {
                maxConected = max(maxConected, walker2(grid, y, x, visited))
            }
        }
    }

    return maxConected
}

fun walker2(grid: Array<Array<Int>>, y: Int, x: Int, visited: HashMap<Int, Int>): Int {
    if (y in grid.indices && x in grid[y].indices && grid[y][x] == 1 && visited[(y * grid[y].size) + x] != 1) {
        val index = (y * grid[y].size) + x
        visited[index] = 1
        return walker2(grid, y + 1, x, visited) +
            walker2(grid, y - 1, x, visited) +
            walker2(grid, y, x + 1, visited) +
            walker2(grid, y, x - 1, visited) + 1
    }
    return 0
}

// My breadth first search
fun maxConnectedBFS(grid: Array<Array<Int>>): Int {
    var maxConected = 0
    val visited = HashMap<Int, Int>()
    val queue: Queue<Pair<Int, Int>> = ArrayDeque()

    for (y in grid.indices) {
        for (x in grid[y].indices) {
            queue.add(x to y)
            val index = (y * grid[y].size) + x
            if (grid[y][x] == 1 && visited[index] == null) {
                maxConected = max(maxConected, walkerBFS(grid, queue, visited))
            }
        }
    }

    return maxConected
}

fun walkerBFS(grid: Array<Array<Int>>, queue: Queue<Pair<Int, Int>>, visited: HashMap<Int, Int>): Int {
    var maxConected = 0
    while (queue.isNotEmpty()) {
        val cell = queue.poll()
        if (cell.second in grid.indices && cell.first in grid[cell.second].indices && grid[cell.second][cell.first] == 1 && visited[(cell.second * grid[cell.second].size) + cell.first] != 1) {
            val index = (cell.second * grid[cell.second].size) + cell.first
            visited[index] = 1
            maxConected++
            queue.add(cell.second + 1 to cell.first)
            queue.add(cell.second - 1 to cell.first)
            queue.add(cell.second to cell.first + 1)
            queue.add(cell.second to cell.first - 1)
        }
    }
    return maxConected
}

// My DFS
fun maxConnectedDFS(grid: Array<Array<Int>>): Int {
    var maxConected = 0
    val visited = HashMap<Int, Int>()
    val stack: Stack<Pair<Int, Int>> = Stack()

    for (y in grid.indices) {
        for (x in grid[y].indices) {
            stack.add(x to y)
            val index = (y * grid[y].size) + x
            if (grid[y][x] == 1 && visited[index] == null) {
                maxConected = max(maxConected, walkerDFS(grid, stack, visited))
            }
        }
    }

    return maxConected
}

fun walkerDFS(grid: Array<Array<Int>>, stack: Stack<Pair<Int, Int>>, visited: HashMap<Int, Int>): Int {
    var maxConected = 0
    while (stack.isNotEmpty()) {
        val cell = stack.pop()
        if (cell.second in grid.indices && cell.first in grid[cell.second].indices && grid[cell.second][cell.first] == 1 && visited[(cell.second * grid[cell.second].size) + cell.first] != 1) {
            val index = (cell.second * grid[cell.second].size) + cell.first
            visited[index] = 1
            maxConected++
            stack.push(cell.second + 1 to cell.first)
            stack.push(cell.second - 1 to cell.first)
            stack.push(cell.second to cell.first + 1)
            stack.push(cell.second to cell.first - 1)
        }
    }
    return maxConected
}