package techlead

import kotlin.math.max

/*
    How mush consecutive ones in binary format?
 */
fun main() {
    println(consecutiveBits(242))
}

// Tech Lead. check is last is one by `and`. Move all to right by >> (`shr`)
fun consecutiveBits(number: Int): Int {
    var localNumber = number
    val BITMASK = 1
    var longestRun = 0
    var currentRun = 0
    while (localNumber != 0) {
        if (localNumber and BITMASK == 0) {
            longestRun = max(longestRun, currentRun)
            currentRun = 0
        } else {
            currentRun++
        }
        localNumber = localNumber shr 1
    }
    longestRun = max(longestRun, currentRun)
    return longestRun
}