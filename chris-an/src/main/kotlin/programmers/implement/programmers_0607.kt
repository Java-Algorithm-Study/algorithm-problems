package main.kotlin.programmers.implement

/**
 * 문자열 나누기
 * https://school.programmers.co.kr/learn/courses/30/lessons/140108
 */
class programmers_0607 {
    fun solution(s: String): Int {
        var answer = 0
        var target = ' '
        var (targetCount, otherCount) = 0 to 0

        for (each in s.iterator()) {
            // 타겟 세팅
            if (targetCount == 0) {
                target = each
                targetCount++
                continue
            }

            // target, other 카운트
            if (target != each) {
                otherCount++
            } else {
                targetCount++
            }

            // 만약 갯수가 같을 경우, 초기화
            if (targetCount == otherCount) {
                targetCount = 0
                otherCount = 0
                target = ' '
                answer++
            }
        }
        if (target != ' ') answer++
        return answer
    }

    fun solution_stack(s: String): Int {
        var answer: Int = 0

        val stack = mutableListOf<Char>()

        s.forEach {
            if (stack.isEmpty()) {
                answer++
                stack.add(it)
            } else if (stack.first() == it) {
                stack.add(it)
            } else {
                stack.removeFirst()
            }
        }

        return answer
    }
}

fun main() {
    println(programmers_0607().solution("banana"))
    println(programmers_0607().solution_stack("abracadabra"))
    println(programmers_0607().solution_stack("aaabbaccccabba"))
}