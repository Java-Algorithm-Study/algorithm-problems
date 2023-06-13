package main.kotlin.leetcode

class leetcode_0613 {
    fun isOneEditDistance(s: String, t: String): Boolean {
        if (s.length > t.length)
            return isOneEditDistance(t, s)

        var (i, j) = 0 to 0
        while (i < s.length && j < t.length) {
            if (s[i] != t[j]) {
                return s.substring(i + 1) == t.substring(j + 1) ||
                        s.substring(i) == t.substring(j + 1)
            }
            i++
            j++
        }
        return t.length - j == 1
    }
}

fun main() {
    println(leetcode_0613().isOneEditDistance(
        "",
        ""
    ))
}