package main.kotlin.leetcode

/**
 * Find the Town Judge
 * https://leetcode.com/problems/find-the-town-judge/description/
 */
class leetcode_0708 {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val trustee = Array(n) { 0 }
        val givener = Array(n) { 0 }
        trust.forEach {
            trustee[it.last() - 1]++
            givener[it.first() - 1]++
        }
        val candidates = trustee.zip(givener).mapIndexed { index, values ->
                if (values.first == n - 1 && values.second == 0) index + 1 else null
            }.filterNotNull()

        return if (candidates.size == 1) candidates.first() else -1
    }
}

fun main() {
    println(
        leetcode_0708().findJudge(
            3, arrayOf(
                intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 1)
            )
        )
    )
}