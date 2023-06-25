package main.kotlin.leetcode

/**
 * Diagonal Traverse
 * https://leetcode.com/problems/diagonal-traverse/
 *
 * TC -> O(m * n)
 * SC -> O(m * n)
 */
class leetcode_0624 {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val colum = mat[0].size
        val row = mat.size

        var turn = 'R'
        val list = mutableListOf<Int>()
        var (i, j) = 0 to 0
        for (k in 0 until   colum * row) {
            list.add(mat[i][j])
            when (turn) {
                'L' -> run {
                    // left & down
                    if (i == row-1) {
                        j++
                        turn = 'R'
                        return@run
                    }
                    if (j == 0) {
                        i++
                        turn = 'R'
                        return@run
                    }
                    i++
                    j--
                }

                'R' -> run {
                    // right & up
                    if (j == colum-1) {
                        i++
                        turn = 'L'
                        return@run
                    }
                    if (i == 0) {
                        j++
                        turn = 'L'
                        return@run
                    }
                    i--
                    j++
                }
            }
        }
        return list.toIntArray()
    }
}

fun main() {
    println(
        leetcode_0624().findDiagonalOrder(
            arrayOf(
                intArrayOf(1,2,3),
                intArrayOf(4,5,6),
                intArrayOf(7,8,9)
            )
        )
    )
}