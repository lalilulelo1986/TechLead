package techlead.noveo

import techlead.common.LinkedNode

fun main() {
    val obj = MyHashMap()
    obj.put(1, 1)
    println(obj)
    obj.put(1, 2)
    println(obj)
    obj.put(2, 55)
    println(obj)
    obj.remove(2)
    println(obj)
}

class MyHashMap {
    private val bucket = MutableList<LinkedNode<Pair<Int, Int>>?>(32 * 32) { null }

    fun put(key: Int, value: Int) {
        val position = key.hashCode().mod(bucket.size)

        if (bucket[position] == null) {
            bucket[position] = LinkedNode(key to value)
            return
        }

        val node = findNode(key)
        if (node == null) {
            bucket[position] = LinkedNode(key to value).also { it.next = bucket[position] }
            bucket[position] = LinkedNode(key to value)
        } else {
            node.value = key to value
        }
    }

    fun get(key: Int): Int {
        val position = key.hashCode().mod(bucket.size)
        if (bucket[position] == null)
            return -1
        return findNode(key)?.value?.second ?: -1
    }

    fun remove(key: Int) {
        removeNode(key)
    }

    private fun findNode(key: Int): LinkedNode<Pair<Int, Int>>? {
        val position = key.hashCode().mod(bucket.size)
        if (bucket[position] == null)
            return null

        var curr = bucket[position]
        while (curr != null) {
            if (curr.value.first == key)
                return curr
            curr = curr.next
        }

        return null
    }

    private fun removeNode(key: Int) {
        val position = key.hashCode().mod(bucket.size)
        if (bucket[position] == null)
            return

        var curr = bucket[position]
        var prev: LinkedNode<Pair<Int, Int>>? = null
        var step = 0
        while (curr != null) {
            if (curr.value.first == key) {
                if (step == 0) {
                    bucket[position] = bucket[position]?.next
                } else {
                    prev?.next = curr.next
                    curr = null
                }
            }

            prev = curr
            curr = curr?.next
            step++
        }

    }

    override fun toString(): String {
        return "MyHashMap(bucket=${bucket.filterNotNull()})"
    }

}