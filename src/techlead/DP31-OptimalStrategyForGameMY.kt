package techlead

import kotlin.math.max
import kotlin.math.min

// geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
fun main() {
    val coins = mutableListOf(20, 30, 2, 2, 2, 10)
    val cacheTurn = Array(coins.size) { Array(coins.size) { 0 } }

    println(coins)
    println(maxMoney(coins, cacheTurn, true))
}

fun maxMoney(
    coins: List<Int>,
    cacheTurn: Array<Array<Int>>,
    myTurn: Boolean,
    start: Int = 0,
    end: Int = coins.size - 1
): Int {
    if (start == end)
        return if (myTurn) coins[start] else 0

    if (cacheTurn[start][end] != 0)
        return cacheTurn[start][end]

    val maxLeft = coins[start] + maxMoney(coins, cacheTurn, !myTurn, start + 1, end)
    val maxRight = coins[end] + maxMoney(coins, cacheTurn, !myTurn, start, end - 1)
    val maxMoney = if (myTurn)
        max(maxLeft, maxRight)
    else
        min(maxLeft - coins[start], maxRight - coins[end])

    if (cacheTurn[start][end] == 0)
        cacheTurn[start][end] = maxMoney

    return maxMoney
}