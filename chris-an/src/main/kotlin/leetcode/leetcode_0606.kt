package main.kotlin.leetcode

class leetcode_0606 {

    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        arr.sort()
        val diff = arr[1] - arr[0]
        for (i in 1 until arr.size - 1) {
            val cur = arr[i]
            val nex = arr[i + 1]
            if ((nex - cur) != diff) {
                return false
            }
        }
        return true
    }
}

fun main() {
    println(leetcode_0606().canMakeArithmeticProgression(intArrayOf(3, 5, 1)))
    println(leetcode_0606().canMakeArithmeticProgression(intArrayOf(1, 2, 4)))
    println(leetcode_0606().canMakeArithmeticProgression(intArrayOf(0, 0, 0, 0)))
}


/**
 *
 * 오역 후, 문제 품
 *
 * fun canMakeArithmeticProgression(arr: IntArray): Boolean {
 *         // 동일한 케이스
 *         var count = 0
 *         val target = arr[0]
 *         for (i in 1 until arr.size) {
 *             if (target == arr[i]) {
 *                 count ++
 *             }
 *         }
 *
 *         if (count == arr.size) return false
 *
 *         // top-dwon
 *         var (topDown, bottomUp) = false to false
 *         for (i in 0 until arr.size - 1) {
 *             val cur = arr[i]
 *             val nex = arr[i + 1]
 *             if (cur > nex) {
 *                 bottomUp = true
 *                 break
 *
 *             }
 *         }
 *         // bottom-up
 *
 *         for (i in 0 until arr.size - 1) {
 *             val cur = arr[i]
 *             val nex = arr[i + 1]
 *             if (cur < nex) {
 *                 topDown = true
 *                 break
 *             }
 *         }
 *
 *         return (bottomUp && topDown)
 *     }
 */