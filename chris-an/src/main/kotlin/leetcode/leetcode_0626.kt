package main.kotlin.leetcode

/**
 * Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/submissions/980024735/
 */
class leetcode_0626 {
    fun containsDuplicate(nums: IntArray): Boolean {
        val hash = HashMap<Int, Int>()
        nums.forEach { num ->
            hash[num] = (hash[num] ?: 0) + 1
            if (hash[num] ?: 0 > 1) {
                return true
            }
        }
        return false
    }
}