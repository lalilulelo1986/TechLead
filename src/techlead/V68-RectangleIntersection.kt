package techlead

import java.lang.Integer.max
import java.lang.Integer.min

data class Rectangle(
    val x1: Int,
    val y1: Int,
    val x2: Int,
    val y2: Int
) {
    fun area(rectangle: Rectangle): Int {
        val interX = min(x2, rectangle.x2) - max(x1, rectangle.x1)
        val interY = min(y2, rectangle.y2) - max(y1, rectangle.y1)
        return if (interX < 0 || interY < 0)
            0
        else
            interX * interY
    }
}

fun main() {
    val a = Rectangle(0, 0, 3, 2)
    val b = Rectangle(1, 1, 3, 3)
    println(a.area(b))
}

//class Rectangle(object):
//    def __init__(self, min_x=0, min_y=0, max_x=0, max_y=0):
//self.min_x = min_x
//self.min_y = min_y
//self.max_x = max_x
//self.max_y = max_y
//
//def area(self):
//if self.min_x >= self.max_x:
//return 0
//if self.min_y >= self.max_y:
//return 0
//return (self.max_x - self.min_x) * (self.max_y - self.min_y)
//
//
//def intersect_rect(a, b):
//return Rectangle(max(a.min_x, b.min_x),
//max(a.min_y, b.min_y),
//min(a.max_x, b.max_x),
//min(a.max_y, b.max_y))
//
//
//a = Rectangle(0, 0, 3, 2)
//b = Rectangle(1, 1, 3, 3)
//
//intersection = intersect_rect(a, b)
//print(intersection.area())