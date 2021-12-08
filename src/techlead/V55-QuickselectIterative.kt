package techlead

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min

fun main() {
    val arr = arrayOf(4, 3, 5, 2, 0, 1)
    println("heap largest: ${findKthLargest(arr, 3)}")
    println(quickSelect(arr, 3))
    val arr2 = arrayOf(8, 7, 2, 3, 4, 1, 5, 6, 9, 0)
    println("heap largest: ${findKthLargest(arr2, 4)}")
    println(quickSelect(arr2, 3))
}

// My fast
fun quickSelect(array: Array<Int>, k: Int): Int {
    var partStart = 0
    var partEnd = array.size - 1
    var pivot = 0
    var p1 = 0
    var p2 = 0
    var tmp: Int

    while (partStart != partEnd) {
        while (p2 <= partEnd) {
            if (array[p2] < array[pivot]) {
                p1++
                if (p2 > p1) {
                    tmp = array[p1]
                    array[p1] = array[p2]
                    array[p2] = tmp
                }
            }
            p2++
        }
//        println("partStart: $partStart, partEnd: $partEnd, p1: $p1, p2: $p2, pivot: $pivot")
        tmp = array[pivot]
        array[pivot] = array[p1]
        array[p1] = tmp

        if (p1 == k - 1) {
            return array[p1]
        } else if (p1 > k - 1) { // go to left partition
            partEnd = p1 - 1
            pivot = partStart
            p1 = partStart
            p2 = partStart
        } else { // go to right partition
            partStart = ++p1
            pivot = p1
            p2 = p1
        }
        if (partStart == partEnd)
            return array[p1]
//        println(array.toList())
    }

    return 0
}

// My heap
fun findKthLargest(array: Array<Int>, k: Int): Int? {
    val heap = PriorityQueue<Int> { f, s -> s - f }
    array.forEach { heap.add(it) }
    for (s in 1 until k)
        heap.poll()
    return heap.poll()
}

/* TechLead
import heapq


def findKthLargest(arr, k):
  for i in range(0, k):
    (max_value, max_index) = (arr[0], 0)
    for j in range(0, len(arr)):
      if max_value < arr[j]:
        (max_value, max_index) = arr[j], j
    arr = arr[:max_index] + arr[max_index + 1:]
  for j in range(0, len(arr)):
    if max_value < arr[j]:
      (max_value, max_index) = arr[j], j
  return max_value


def findKthLargest2(arr, k):
  return sorted(arr)[-k]


def findKthLargest2(arr, k):
  arr = list(map(lambda x: -x, arr))
  heapq.heapify(arr)
  for i in range(0, k - 1):
    heapq.heappop(arr)
  return -arr[0]


def partition(arr, low, high):
  pivot = arr[high]
  i = low
  for j in range(low, high):
    if arr[j] <= pivot:
      arr[i], arr[j] = arr[j], arr[i]
      i += 1
  arr[i], arr[high] = arr[high], arr[i]
  return i


def quickselect(arr, k):
  k = len(arr) - k
  left = 0
  right = len(arr) - 1

  while left <= right:
    pivotIndex = partition(arr, left, right)
    if pivotIndex == k:
      return arr[pivotIndex]
    elif pivotIndex > k:
      right = pivotIndex - 1
    else:
      left = pivotIndex + 1
  return -1


print(quickselect([8, 7, 2, 3, 4, 1, 5, 6, 9, 0], 3))
 */