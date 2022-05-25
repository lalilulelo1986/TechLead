package techlead

fun main() {
    val exprestion = "1 + ((1 + (2 + (3 + (4 + 5))))) - 8"
    val exprestion2 = "10 - (3 - 4)"
    println(Solution16(exprestion2.toCharArray()).calculate())
}

// My solution 1
class Solution16(val charArray: CharArray) {
    var index1 = -1
    fun calculate(): Int {
        var result = 0
        var operand: String? = "0"
        var operator: Char? = '+'

        while (index1 < charArray.size - 1) {
            index1++
            if (charArray[index1] == '(') {
                result = summ(result, calculate(), operator)
            } else if (charArray[index1] == ')') {
                return summ(result, operand?.toInt(), operator)
            } else if (charArray[index1] == '+' || charArray[index1] == '-') {
                result = summ(result, operand?.toInt(), operator)
                operator = charArray[index1]
                operand = "0"
            } else {
                if (charArray[index1].isDigit())
                    operand += charArray[index1]
            }
            if (index1 == charArray.size - 1) {
                result = summ(result, operand?.toInt(), operator)
            }
        }
        return result
    }

    fun summ(n1: Int, n2: Int?, operand: Char?): Int {
        if (operand == '+')
            return n1 + (n2 ?: 0)
        else if (operand == '-')
            return n1 - (n2 ?: 0)
        else
            return n1
    }
}