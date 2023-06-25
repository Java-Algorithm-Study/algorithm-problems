package main.kotlin.leetcode

/**
 * Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 */
class leetcode_0619 {
    fun generateMatrix(n: Int): Array<IntArray> {
        var matrix = Array(n) { IntArray(n) }
        var direction = 'R'
        var leftSide = 0
        var rightSide = n - 1
        var topSide = 1
        var bottomSide = n - 1
        var (i, j) = 0 to 0
        for (k in 0 until n * n) {
            matrix[i][j] = k + 1
            when (direction) {
                'R' -> {
                    j++
                    if (j == rightSide) {
                        direction = 'D'
                        rightSide--
                    }
                }
                'D' -> {
                    i++
                    if (i == bottomSide) {
                        direction = 'L'
                        bottomSide--
                    }
                }
                'L' -> {
                    j--
                    if (j == leftSide) {
                        direction = 'U'
                        leftSide++
                    }
                }
                'U' -> {
                    i--
                    if (i == topSide) {
                        direction = 'R'
                        topSide++
                    }
                }
            }
        }
        return matrix
    }
}