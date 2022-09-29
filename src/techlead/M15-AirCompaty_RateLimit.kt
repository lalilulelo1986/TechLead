package techlead

import java.lang.Thread.sleep
import java.time.Instant
import kotlin.random.Random

fun main() {
    val rateLimit = RateLimit(10, 5)

    var waitForTrue = 500
    while (true) {
        val now = Instant.now().epochSecond
        if (rateLimit.ask()) {
            println("#TRUE#: $now")
            waitForTrue--
        } else {
            println("false: $now")
        }
        if (waitForTrue == 0) {
            break
        }
//        Random.nextInt(0, 2000)
        //println("rateLimit: ${rateLimit.ask()}")
        sleep(Random.nextLong(0, 3000))
    }
}

class RateLimit(private val periodSeconds: Int, private val rate: Int) {
    private var currentSize = 0
    private val bucketSize = 100
    private val bucket = MutableList(bucketSize) { 0 }
    private val secondHistory = Array(bucketSize) { 0L }

    fun ask(): Boolean {
        val nowMilli = Instant.now().toEpochMilli()
//        val bucketPosition = (now.toEpochMilli() / 10 % bucketSize).toInt()

//        val bucketPosition = (now.toEpochMilli() / (bucketSize / 10) % bucketSize).toInt()
        val bucketPosition = (nowMilli / ((periodSeconds * 1000) / (bucketSize / 10)) % bucketSize).toInt()
        val period = nowMilli / 1000
        for (i in secondHistory.indices) {
            if (secondHistory[i] < period - 1 * periodSeconds || secondHistory[i] == period - 1 * periodSeconds && bucketPosition >= i) {
                currentSize -= bucket[i]
                bucket[i] = 0
                secondHistory[i] = period
            }
        }
//        println("bucketPosition: $bucketPosition; second: $period; currentSize: $currentSize")

        if (currentSize >= rate) {
            return false
        }

        bucket[bucketPosition] += 1
        secondHistory[bucketPosition] = period
        currentSize += 1

        return true
    }
}