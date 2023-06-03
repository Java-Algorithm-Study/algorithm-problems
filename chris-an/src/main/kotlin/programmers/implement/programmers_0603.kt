package main.kotlin.programmers.implement


class programmers_0603 {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        score.sort()
        val remain = score.size % m
        var count = 1
        for (i in remain until score.size - 1) {
            if (count == m+1) count = 1
            if (count == 1) answer += score[i] * m
            count++
        }
        return answer
    }
}

fun main() {
    println(
        programmers_0603().solution(
            4,
            3,
            intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)
        )
    )
}