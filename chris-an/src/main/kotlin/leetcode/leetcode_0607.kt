package main.kotlin.leetcode

/**
 * Two Sum
 * https://leetcode.com/problems/two-sum/description/
 * 탐색해야하는 수는 2 ~ 10,000
 * num 숫자 는 Int 범위
 * 타겟 숫자 또한, Int 범위
 */
class leetcode_0607 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var map = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, key ->
            val value = target - nums[index]
            if (map.containsKey(value))
                return intArrayOf(map[value] ?: 0, index)
            map[key] = index
        }
        return intArrayOf(0)
    }
}

fun main() {
    println(
        leetcode_0607().twoSum(
            intArrayOf(2,7,11,15),
            9
        )
    )

    println(
        leetcode_0607().twoSum(
            intArrayOf(3,2,4),
            6
        )
    )
}

