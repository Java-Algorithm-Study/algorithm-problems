package main.kotlin.leetcode

import java.lang.Integer.MAX_VALUE
import java.lang.Integer.MIN_VALUE
import kotlin.math.abs

/**
 * Maximum Distance in Arrays
 * https://leetcode.com/problems/maximum-distance-in-arrays/?envType=study-plan-v2&envId=premium-algo-100
 */
class leetcode_0608 {
    fun maxDistance(arrays: List<List<Int>>): Int {
        var (max, min) = MIN_VALUE to MAX_VALUE
        var (maxIdx, minIdx) = 0 to 0
        arrays.forEachIndexed { index, array ->
            val mx = array.max()
            val mn = array.min()
            if (mx > max) {
                max = mx
                maxIdx = index
            }
            if (mn < min) {
                min = mn
                minIdx = index
            }
        }
        var result = 0
        if (maxIdx == minIdx) {
            val list = arrays.toMutableList()
            list.removeAt(maxIdx)

            list.forEach { array ->
                val mx = array.max()
                val mn = array.min()
                val target = if (mx - min >= max - mn) { mx - min }else { max - mn }

                if (target >= result) {
                    result = target
                }
            }
        }else {
            return max - min
        }



        return result
    }
}

fun main() {
    println(leetcode_0608().maxDistance(
            listOf(
                    listOf(1,2,3),
                    listOf(4,5),
                    listOf(1,2,3)
            )
    ))

    println(leetcode_0608().maxDistance(
            listOf(
                    listOf(1,4),
                    listOf(0,5),
            )
    ))
}