package main.kotlin.programmers.implement


fun solution(n: Int, m: Int, section: IntArray): Int {
    var (result, painted) = 0 to 0
    for (peelingArea in section) {
        if (painted <= peelingArea) {
            painted = m + peelingArea
            result++
        }
    }
    return result
}


fun main() {
    println(solution(8, 4, intArrayOf(2, 3, 6)))
    println(solution(5, 4, intArrayOf(1, 3)))
    println(solution(4, 1, intArrayOf(1, 2, 3, 4)))

}