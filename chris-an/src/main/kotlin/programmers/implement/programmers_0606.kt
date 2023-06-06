package main.kotlin.programmers.implement

class programmers_0606_java {
    fun solution(s: String): IntArray {
        var alphaMap = mutableMapOf<Char, Int>()
        var list = mutableListOf<Int>()

        s.forEachIndexed { index, each ->
            if (alphaMap.containsKey(each)) {
                val value = alphaMap[each] ?: 0
                list.add(index - value)
            } else {
                list.add(-1)
            }

            alphaMap[each] = index
        }

        return list.toIntArray()
    }
}

class programmers_0606_kotlin {
    fun solution(s: String): List<Int> {
        return s.withIndex().map { (index, each) ->
            s.slice(0 until index).lastIndexOf(each).let { if (it >= 0) index - it else -1 }
        }
    }
}


fun main() {
    println(programmers_0606_java().solution("banana"))
    println(programmers_0606_kotlin().solution("foobar"))
}