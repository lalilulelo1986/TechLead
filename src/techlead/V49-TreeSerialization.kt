package techlead

import techlead.common.Node
import java.util.*

fun main() {
    val tree = Node(1).also {
        it.left = Node(3).also {
            it.left = Node(2)
            it.right = Node(5)
        }
        it.right = Node(4).also {
            it.right = Node(7).also {
                it.right = Node(9)
            }
        }
    }

    println(tree)
    val serialized = serialize(tree)
    println(serialized)
    println(deserialize(serialized))
}

fun <T> serialize(node: Node<T>): String {
    val queue: Queue<Pair<Node<T>, Int>> = LinkedList()
    queue.add(node to 1)

    val sb = StringBuilder()
    var lastIndex = 0
    while (queue.isNotEmpty()) {
        val polled = queue.poll()
        for (i in 1 until polled.second - lastIndex)
            sb.append("#")
        sb.append(polled.first.value)
        lastIndex = polled.second
        polled.first.left?.also { queue.add(it to polled.second * 2) }
        polled.first.right?.also { queue.add(it to polled.second * 2 + 1) }
    }

    return sb.toString()
}

fun deserialize(data: String): Node<Char>? {
    if (data.isEmpty())
        return null

    val queue: Queue<Pair<Node<Char>, Int>> = LinkedList()
    val root: Node<Char> = Node(data.first())
    queue.add(root to 1)
    while (queue.isNotEmpty()) {
        val polled = queue.poll()
        polled.first.value = data[polled.second - 1]
        if (data.length >= polled.second * 2 && data[polled.second * 2 - 1] != '#')
            polled.first.left = Node(' ').also { queue.add(it to polled.second * 2) }
        if (data.length >= polled.second * 2 + 1 && data[polled.second * 2] != '#')
            polled.first.right = Node(' ').also { queue.add(it to polled.second * 2 + 1) }
    }
    return root
}

//class Node:
//  def __init__(self, val, left=None, right=None):
//      self.val = val
//      self.left = left
//      self.right = right
//
//  def __str__(self):
//      result = ''
//      result += str(self.val)
//      if self.left:
//          result += str(self.left)
//      if self.right:
//          result += str(self.right)
//      return result
//
//
//  def serialize(node):
//      if node == None:
//          return '#'
//      return str(node.val) + ' ' + serialize(node.left) + ' ' + serialize(node.right)
//
//
//  def deserialize(str):
//    def deserialize_helper(values):
//      value = next(values)
//      if value == '#':
//          return None
//      node = Node(int(value))
//      node.left = deserialize_helper(values)
//      node.right = deserialize_helper(values)
//      return node
//  values = iter(str.split())
//  return deserialize_helper(values)
//
//
//#      1
//#     / \
//#    3   4
//#   / \   \
//#  2   5   7
//tree = Node(1)
//tree.left = Node(3)
//tree.right = Node(4)
//tree.left.left = Node(2)
//tree.left.right = Node(5)
//tree.right.right = Node(7)
//string = serialize(tree)
//print(deserialize(string))
//# 132547