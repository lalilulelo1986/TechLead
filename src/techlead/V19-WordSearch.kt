package techlead

fun main() {
    val wordMatrix = arrayOf(
        arrayOf('F', 'A', 'C', 'I'),
        arrayOf('O', 'B', 'Q', 'P'),
        arrayOf('A', 'N', 'O', 'B'),
        arrayOf('M', 'A', 'S', 'S')
    )
    println(MySolution19.findWord(wordMatrix, "FOAM"))
    println(MySolution19.findWord(wordMatrix, "ABNA"))
    println(MySolution19.findWord(wordMatrix, "CQOS"))
    println(MySolution19.findWord(wordMatrix, "IPBS"))
    println(MySolution19.findWord(wordMatrix, "FACI"))
    println(MySolution19.findWord(wordMatrix, "OBQP"))
    println(MySolution19.findWord(wordMatrix, "OBQX"))
}

class MySolution19 {
    companion object {
        fun findWord(array: Array<Array<Char>>, word: String): Boolean {
            val wordArray = word.toCharArray()

            for (x in array.indices) {
                if (array[x].joinToString("") == word)
                    return true

                for (y in array[x].indices) {
                    if (x == 0 && verticalHelper(array, x, y, wordArray)) return true
                }
            }
            return false
        }

        fun verticalHelper(array: Array<Array<Char>>, x: Int, y: Int, wordArray: CharArray, pointer: Int = 0): Boolean {
            if (array[x][y] == wordArray[pointer]) {
                // base case
                if (wordArray.size == pointer + 1)
                    return true

                return verticalHelper(array, x + 1, y, wordArray, pointer + 1)
            } else {
                return false
            }
        }
    }
}