package main.kotlin.programmers.implement

/**
 * 카드뭉치
 * https://school.programmers.co.kr/learn/courses/30/lessons/159994
 */
class programmers_0604 {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var (left, right) = 0 to 0

        goal.forEach {
            if (left < cards1.size && cards1[left] == it) left++
            else if (right < cards2.size && cards2[right] == it) right++
            else return "No"
        }

        return "Yes"
    }
}

fun main() {
    println(
        programmers_0604().solution(
            arrayOf("i", "drink", "water"),
            arrayOf("want", "to"),
            arrayOf("i", "want", "to", "drink", "water")
        )
    )

    println(
        programmers_0604().solution(
            arrayOf("i", "water", "drink"),
            arrayOf("want", "to"),
            arrayOf("i", "want", "to", "drink", "water")
        )
    )
}

