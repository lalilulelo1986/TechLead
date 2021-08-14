fun main() {
    val course1_2 = arrayOf(arrayOf(1, 0))
    val course2_2 = arrayOf(arrayOf(0, 1), arrayOf(1, 2), arrayOf(2, 6), arrayOf(2, 7), arrayOf(11, 12), arrayOf(12, 0))

    val courseSchedule = CourseSchedule()
    courseSchedule.check(course2_2)
    println(courseSchedule.good)

    CourseSchedule2().check(course2_2)
}

// Recurcive
class CourseSchedule {
    var good = true

    fun check(array: Array<Array<Int>>, target: Int? = null, visited: MutableList<Int> = mutableListOf()) {
        for (i in array.indices) {
            if (target == null || array[i][0] == target) {
                if (visited.contains(array[i][1])) {
                    good = false
                    return
                } else {
                    check(
                        (array.toList() - listOf(array[i])).toTypedArray(),
                        array[i][1],
                        (visited + mutableListOf(array[i][0])).toMutableList()
                    )
                }
            }
        }
    }
}

// HashMap
class CourseSchedule2 {

    fun check(array: Array<Array<Int>>) {
        val hashMap = HashMap<Int, MutableList<Int>>()

        for (el in array) {
            if (hashMap.containsKey(el[0]).not()) {
                hashMap[el[0]] = mutableListOf(el[1])
            } else {
                hashMap[el[0]]?.add(el[1])
            }
        }

        println(hashMap)

        //TODO depth first search
    }
}