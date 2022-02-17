package techlead

import java.util.function.Predicate

fun main() {
    println(isNumber("-234.34e3"))
    println(isNumber("-234"))
    println(isNumber("-.43"))
    println(isNumber("34e3"))
    println(isNumber("34ee3"))
}

enum class State(val predicate: Predicate<Char>) : Predicate<Char> {
    BEGIN(Predicate<Char> { true }) {
        override fun test(t: Char): Boolean {
            return true
        }
    },
    NEGATIVE(Predicate<Char> { it == '-' }) {
        override fun test(t: Char): Boolean {
            return t == '-';
        }
    },
    DIGIT1(Predicate<Char> { it in listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9') }) {
        override fun test(t: Char): Boolean {
            return t in listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        }
    },
    DOT(Predicate<Char> { it == '.' }) {
        override fun test(t: Char): Boolean {
            return t == '.'
        }
    },
    DIGIT2(Predicate<Char> { it in listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9') }) {
        override fun test(t: Char): Boolean {
            return t in listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        }
    },
    E(Predicate<Char> { it == 'e' }) {
        override fun test(t: Char): Boolean {
            return t == 'e';
        }
    },
    DIGIT3(Predicate<Char> { it in listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9') }) {
        override fun test(t: Char): Boolean {
            return t in listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        }
    }
}

val nextStateMap = mapOf(
    State.BEGIN to listOf(State.NEGATIVE, State.DOT, State.DIGIT1),
    State.NEGATIVE to listOf(State.DOT, State.DIGIT1),
    State.DIGIT1 to listOf(State.DIGIT1, State.DOT, State.E),
    State.DOT to listOf(State.DIGIT2),
    State.DIGIT2 to listOf(State.DIGIT2, State.E),
    State.E to listOf(State.DIGIT3),
    State.DIGIT3 to listOf(State.DIGIT3)
)

fun isNumber(str: String): Boolean {
    var state = State.BEGIN

    str.forEach { it ->
        val states = nextStateMap[state]
        states?.firstOrNull { newState -> newState.test(it) }?.let {
            state = it
        } ?: run { return false }
    }

    return state in listOf(State.DIGIT1, State.DIGIT2, State.DIGIT3)
}