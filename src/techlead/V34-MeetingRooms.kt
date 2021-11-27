package techlead

import java.util.*
import kotlin.math.max


fun main() {
    // [20, 30], [10, 21], [0, 50]
    var arr = arrayOf(Pair(20, 30), Pair(10, 21)) // 3
    var arr2 = arrayOf(Pair(0, 50), Pair(0, 10), Pair(10, 20), Pair(20, 30), Pair(30, 50))
    var arr3 = arrayOf(Pair(0, 50), Pair(0, 10), Pair(10, 30), Pair(20, 30), Pair(30, 50))
    var arr4 = arrayOf(Pair(0, 9), Pair(0, 3), Pair(1, 4), Pair(2, 6), Pair(4, 7), Pair(6, 9), 4 to 8)

    println(meetingRooms(arr))
    println(meetingRooms(arr2))
    println(meetingRooms(arr3))
    println(meetingRooms(arr4))

    println(meetingRooms2(arr))
    println(meetingRooms2(arr2))
    println(meetingRooms2(arr3))
    println(meetingRooms2(arr4))
}

// my brood force
fun meetingRooms(arr: Array<Pair<Int, Int>>): Int {
    var maxRooms = 0
    for (pair1 in arr) {
        var rooms = 0
        for (pair2 in arr)
            if (pair1.first >= pair2.first && pair1.first < pair2.second)
                rooms++
        maxRooms = max(rooms, maxRooms)
    }
    return maxRooms
}

// TechLead. Fast, ordered, heap.
fun meetingRooms2(arr: Array<Pair<Int, Int>>): Int {
    arr.sortedBy { it.first }
    val meetingEnds = PriorityQueue<Int>()
    var maxRooms = 0

    for (meeting in arr) {
        while (meetingEnds.isNotEmpty() && meetingEnds.peek() <= meeting.first) {
            meetingEnds.poll()
        }
        meetingEnds.add(meeting.second)
        maxRooms = max(maxRooms, meetingEnds.size)
    }

    return maxRooms
}