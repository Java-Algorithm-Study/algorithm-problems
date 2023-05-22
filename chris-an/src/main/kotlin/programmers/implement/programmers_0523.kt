package main.kotlin.programmers.implement

/**
 * 추억 점수
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 *
 */

fun solution(
    name: Array<String>,
    yearning: IntArray,
    photo: Array<Array<String>>
): IntArray {

    val map = name.zip(yearning.toTypedArray()).toMap()
    return photo.map { p -> p.sumOf { map[it] ?: 0 } }.toIntArray()
}

/**
 * stream 사용
 */
fun solution2(
    name: Array<String>,
    yearning: IntArray,
    photo: Array<Array<String>>
): IntArray {

    val board = mutableMapOf<String, Int>()
    name.forEachIndexed { index, s -> board[s] = yearning[index] }

    var answer = IntArray(photo.size)
    photo.forEachIndexed { index, s ->
        var sum = 0
        s.forEach {
            if (board.containsKey(it)) {
                sum += board[it]!!
            }
        }
        answer[index] = sum
    }
    return answer
}



fun main() {
    println(
        solution(
            arrayOf("may", "kein", "kain", "radi"),
            intArrayOf(5, 10, 1, 3),
            arrayOf(
                arrayOf("may", "kein", "kain", "radi"),
                arrayOf("may", "kein", "brin", "deny"),
                arrayOf("kon", "kain", "may", "coni")
            )
        )
    )

    println(
        solution2(
            arrayOf("may", "kein", "kain", "radi"),
            intArrayOf(5, 10, 1, 3),
            arrayOf(
                arrayOf("may", "kein", "kain", "radi"),
                arrayOf("may", "kein", "brin", "deny"),
                arrayOf("kon", "kain", "may", "coni")
            )
        )
    )
}
