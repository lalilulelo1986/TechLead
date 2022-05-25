package techlead

import java.lang.Integer.max

// https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
/*
    If last characters of both sequences match (or X[m-1] == Y[n-1]) then
    L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])

    If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
    L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2]) )
 */
fun main() {
    println(lcs("AGGTAB", "GXTXAYB"))
}

fun lcs(first: String, second: String): Int {
    if (first.isBlank() || second.isBlank())
        return 0

    if (first.last() == second.last()) {
        return 1 + lcs(first.substring(0, first.length - 1), second.substring(0, second.length - 1))
    } else {
        return max(
            lcs(first.substring(0, first.length - 1), second.substring(0, second.length)),
            lcs(first.substring(0, first.length), second.substring(0, second.length - 1))
        )
    }
}