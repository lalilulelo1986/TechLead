package techlead

import techlead.common.Node
import java.util.*

/*
#  1
# / \
#2   3
#   / \
#  4*  5
a = Node(1)
a.left = Node(2)
a.right = Node(3)
a.right.left = Node(4)
a.right.right = Node(5)

b = Node(1)
b.left = Node(2) 
b.right = Node(3)
b.right.left = Node(4)
b.right.right = Node(5)

print(findNode2(a, b, a.right.left))
# 4
 */
fun main() {
    val a = Node(1).also {
        it.left = Node(2)
        it.right = Node(3).also {
            it.left = Node(4)
            it.right = Node(5)
        }
    }
    val b = Node(1).also {
        it.left = Node(2)
        it.right = Node(3).also {
            it.left = Node(4)
            it.right = Node(5)
        }
    }
    println(findClone(a, b, a.right!!.left!!))
    println(findClone2(a, b, a.right!!.left!!))
}

fun findClone(a: Node<Int>, b: Node<Int>, target: Node<Int>): Node<Int>? {
    val stack = Stack<Node<Int>>()
    stack.push(a)
    stack.push(b)
    while (stack.isNotEmpty()) {
        val b1 = stack.pop()
        val a1 = stack.pop()
        if (a1 === target)
            return b1
        if (a1.left != null) {
            stack.push(a1.left)
            stack.push(b1.left)
        }
        if (a1.right != null) {
            stack.push(a1.right)
            stack.push(b1.right)
        }
    }

    return null
}

fun findClone2(a: Node<Int>, b: Node<Int>, target: Node<Int>): Node<Int>? {
    if (a === target)
        return b
    if (a.left != null) {
        val res = findClone2(a.left!!, b.left!!, target)
        if (res != null) return res
    }
    if (a.right != null) {
        val res =findClone2(a.right!!, b.right!!, target)
        if (res != null) return res
    }
    return null
}

/*
class Node:
  def __init__(self, val):
    self.val = val
    self.left = None
    self.right = None

  def __str__(self):
    return str(self.val)

def findNode(a, b, node):
  if a == node:
    return b
  if a.left and b.left:
    found = findNode(a.left, b.left, node)
    if found:
      return found
  if a.right and b.right:
    found = findNode(a.right, b.right, node)
    if found:
      return found
  return None

def findNode2(a, b, node):
  stack = [(a, b)]
  while len(stack):
    (a,b) = stack.pop()
    if a == node:
      return b
    if a.left and b.left:
      stack.append((a.left, b.left))
    if b.right and b.right:
      stack.append((a.right, b.right))
  return None

#  1
# / \
#2   3
#   / \
#  4*  5
a = Node(1)
a.left = Node(2)
a.right = Node(3)
a.right.left = Node(4)
a.right.right = Node(5)

b = Node(1)
b.left = Node(2)
b.right = Node(3)
b.right.left = Node(4)
b.right.right = Node(5)

print(findNode2(a, b, a.right.left))
# 4
 */