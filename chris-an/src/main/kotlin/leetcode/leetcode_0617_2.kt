package main.kotlin.leetcode

/**
 * Palindrome Permutation
 * https://leetcode.com/problems/palindrome-permutation/description/?envType=study-plan-v2&envId=premium-algo-100
 */
class leetcode_0617_2 {
    fun canPermutePalindrome(s: String): Boolean {
        var map = HashMap<Char, Int>()
        for (c in s) {
            map[c] = (map[c] ?: 0) + 1
        }
        var oddCount = 0
        for (v in map.values) {
            if (v % 2 == 1) oddCount++
        }
        return oddCount <= 1
    }
}

fun main() {
    println(
        leetcode_0617_2().canPermutePalindrome(
            "aab"
        )
    )
}