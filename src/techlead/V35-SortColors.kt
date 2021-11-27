package techlead

import java.time.Instant
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    // 3 distinct color
    val colors = Array<Int>(1000_000_000) { 1 }
    for (i in colors.indices) {
        colors[i] = Random.nextInt(1, 4)
    }
//    val randomValues = List(10_000_000_0) { Random.nextInt(1, 4) }.also { }.toTypedArray()
//    val colors = arrayOf(1, 2, 3, 1, 3, 3, 2)

    var start = Instant.now().toEpochMilli()
    sortThreeUnique(colors)
    println((Instant.now().toEpochMilli() - start) / 1000)

    start = Instant.now().toEpochMilli()
    sortThreeUniqueHash(colors)
    println((Instant.now().toEpochMilli() - start) / 1000)
}

// My swap. Fix when less than 3 colors
fun sortThreeUnique(array: Array<Int>): Array<Int> {
    var one = -1
    var two = -1
    var three = -1
    for (x in array.indices) {
        var tmp: Int
        if (one == -1) {
            one = x
            continue
        } else if (two == -1 && array[one] != array[x]) {
            two = x
            tmp = array[one]
            array[one] = min(array[one], array[x])
            array[two] = max(tmp, array[x])
            continue
        } else if (three == -1 && array[two] != array[x]) {
            three = x
            if (array[three] < array[one]) {
                tmp = array[three]
                array[three] = array[two]
                array[two] = array[one]
                array[one] = tmp
                continue
            } else if (array[three] < array[two]) {
                tmp = array[three]
                array[three] = array[two]
                array[two] = tmp
                continue
            }
        }
        if (three == -1)
            continue

        if (array[x] < array[two]) {
            array[x] = array[three]
            array[three] = array[two]
            array[two] = array[one]
            two++
            three++
        } else if (array[x] < array[three]) {
            array[x] = array[three]
            array[three] = array[two]
            three++
        }

    }

    return array
}

// my hashTable and arrayOf 3 el
fun sortThreeUniqueHash(array: Array<Int>): Array<Int> {
    val sortedUnique = TreeSet<Int>()
    val hashMap = HashMap<Int, Int>()

    for (el in array) {
        sortedUnique.add(el)
        hashMap.computeIfAbsent(el) { 0 }
        hashMap.computeIfPresent(el) { _, v -> v + 1 }
    }

    var ind = 0
    for (el in sortedUnique) {
        for (times in 1..hashMap[el]!!) {
            array[ind] = el
            ind++
        }
    }

    return array
}

// tech Solution with only 2 pointers
//def sortColor2(self, colors):
//  lowIndex = 0
//  highIndex = len(colors) - 1
//  currIndex = 0
//
//  while currIndex <= highIndex:
//    if colors[currIndex] == 0:
//      colors[lowIndex], colors[currIndex] = colors[currIndex], colors[lowIndex]
//      lowIndex += 1
//      currIndex += 1
//    elif colors[currIndex] == 2:
//      colors[highIndex], colors[currIndex] = colors[currIndex], colors[highIndex]
//      highIndex -= 1
//    else:
//      currIndex += 1