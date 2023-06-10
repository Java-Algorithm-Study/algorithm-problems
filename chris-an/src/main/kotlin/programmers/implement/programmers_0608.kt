package main.kotlin.programmers.implement

import javax.swing.text.html.HTML.Attribute.N


class programmers_0608 {
    fun solution(number: Int, limit: Int, power: Int): Int {
        return (1..number).fold(0) { result, num ->
            val divisor = (1..num).map { it * it }.filter { it <= num }.fold(0) { acc, i ->
                if(i == num) acc + 1
                else if (i == 1) acc + 2
                else if (num % (i/2) == 0) acc + 2
                else acc }
            if (divisor > limit)
                result + power
            else
                result + divisor
        }
    }
}

fun main() {
    println(
            programmers_0608().solution(
                    10,
                    3,
                    2
            )
    )
}