package main.kotlin.leetcode

class leetcode_0610 {
    fun wiggleSort(nums: IntArray): Unit {
        nums.sort()
        val result = mutableListOf<Int>()
        var targetIndex = nums.size / 2

        var flag = false
        if (nums.size % 2 != 0) {
            targetIndex++
            flag = true
        }
        for (i in 0 until targetIndex) {
            result.add(nums[i])

            // if 조건으로, pass
            if (i + targetIndex >= nums.size && flag) break
            result.add(nums[i + targetIndex])
        }

        for (i in 0 until nums.size) {
            nums[i] = result[i]
        }
    }
}

fun main() {
    println(
            leetcode_0610().wiggleSort(
                    intArrayOf(1,2,3)
            )
    )
}