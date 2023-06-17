package main.kotlin.leetcode

/**
 * Find Anagram Mappings
 * https://leetcode.com/problems/find-anagram-mappings/?envType=study-plan-v2&envId=premium-algo-100
 */
class leetcode_0617 {
    fun anagramMappings(nums1: IntArray, nums2: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums2.forEachIndexed { index, num ->
            map[num] = index
        }

        val result = mutableListOf<Int>()
        nums1.forEach { num ->
            val value = map[num] ?: 0
            result.add(value)
        }
        return result.toIntArray()
    }
}

fun main() {
    println(
        leetcode_0617().anagramMappings(
            intArrayOf(12,28,46,32,50),
            intArrayOf(50,12,32,46,28)
        )
    )
}