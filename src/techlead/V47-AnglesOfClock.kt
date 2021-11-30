package techlead

import java.lang.Math.abs

fun main() {
    val hour = 3
    val minute = 13
    println(findAngle(3, 15))
    println(findAngle(3, 0))
}

fun findAngle(hour: Int, minute: Int): Double {
    val hAng = (hour * 30.0) + (minute / 2.0)
    val mAng = minute * 6.0
    return abs(hAng - mAng)
}