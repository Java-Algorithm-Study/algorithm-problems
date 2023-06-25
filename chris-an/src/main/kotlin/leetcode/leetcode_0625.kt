package main.kotlin.leetcode

/**
 * 3Sum
 * https://leetcode.com/problems/3sum/solutions/3507397/kotlin-2-pointers-easier-than-you-think/
 */
class leetcode_0625 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val ans = mutableSetOf<List<Int>>()
        nums.sort()

        for (i in 0 until nums.size-2){
            var left = i + 1
            var right = nums.size-1
            while (left < right){

                val sum = nums[i] + nums[left] + nums[right]

                if (sum == 0){
                    ans.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--
                }

                else if (sum < 0) left++

                else right--
            }
        }
        return ans.toList()
    }
}

fun main() {
    println(
        leetcode_0625().threeSum(
            intArrayOf(-1,0,1,2,-1,-4)
        )
    )
}