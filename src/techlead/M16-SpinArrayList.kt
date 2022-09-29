package techlead

import java.lang.Integer.max
import java.lang.Integer.min

fun main() {
    val listOf = arrayListOf(1, 2, 3, 4, 5)
    val lastElement = listOf.size - 1
    val spin = 3

    for (i in 1..spin) {
        listOf.add(0, listOf.removeAt(lastElement))
    }
    println(listOf)

    println((1..3).asSequence().map { 1 }.toList())
}

fun sqInRect(lng: Int, wdth: Int): List<Int>? {
    if (lng == wdth) return null
    return sqInRect2(lng, wdth)
}

fun sqInRect2(lng: Int, wdth: Int): List<Int>? {
    if (lng == 0 || wdth == 0) return listOf()
    if (lng == 1 || wdth == 1) return (1..max(lng, wdth)).asSequence().map { 1 }.toList()

    val minL = min(lng, wdth)
    return listOf(minL) + if (lng > wdth) sqInRect(lng - minL, wdth) ?: emptyList() else sqInRect(lng, wdth - minL)
        ?: emptyList()
}