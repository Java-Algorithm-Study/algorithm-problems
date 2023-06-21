package main.kotlin.leetcode

/**
 * Build Array from Permutation
 * https://leetcode.com/problems/build-array-from-permutation/
 */
class leetcode_0621 {
    fun buildArray(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        for (index in nums.indices) {
            result[index] = nums[nums[index]]
        }

        return result
    }
}

fun main() {
    println(leetcode_0621().buildArray(
        intArrayOf(0,2,1,5,3,4)
    ))
}