package main.kotlin.leetcode

/**
 * Subarray Sums Divisible by K
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
 */
class leetcode_0630 {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val counter = mutableMapOf(Pair(0, 1))
        var sum = 0
        var result = 0
        for (num in nums) {
            sum += num
            sum %= k
            if (sum < 0) sum = (sum + k) % k
            result += counter.getOrDefault(sum, 0)
            counter[sum] = counter.getOrDefault(sum, 0) + 1
        }
        return result
    }
}