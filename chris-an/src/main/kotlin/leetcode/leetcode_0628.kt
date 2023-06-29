package main.kotlin.leetcode

/**
 * First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
class leetcode_0628 {
    fun firstUniqChar(s: String): Int {
        val charCounts = IntArray(26);
        s.forEach { c ->
            charCounts[c - 'a']++;
        }

        s.forEachIndexed { i, c ->
            if (charCounts[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}