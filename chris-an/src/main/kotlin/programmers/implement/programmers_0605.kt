package main.kotlin.programmers.implement

/**
 * 크기가 작은 부분 문자열
 * https://school.programmers.co.kr/learn/courses/30/lessons/147355
 */
class programmers_0605 {
    fun solution_java(t: String, p: String): Int {
        val lastIndex = t.length - p.length
        var count = 0
        for (i in 0..lastIndex) {
            val target = t.substring(i, i + p.length).toLong()
            if (target <= p.toLong()) count++
        }
        return count
    }

    fun solution_kotlin(t: String, p: String): Int {
        return (0..t.length - p.length)
            .map { t.substring(it until it + p.length) }
            .count { it <= p }
    }
}

fun main() {
    println(
        programmers_0605().solution_java(
            "3141592",
            "271"
        )
    )

    println(
        programmers_0605().solution_kotlin(
            "500220839878",
            "7"
        )
    )

    println(
        programmers_0605().solution_kotlin(
            "10203",
            "15"
        )
    )
}