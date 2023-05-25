package main.kotlin.programmers.implement


class programmers_0525 {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val answer = mutableListOf<Int>()
        targets.forEach { target ->
            var totalNumberOfClicks = 0
            for (value in target.iterator()) {
                val min = findTheLeastNumber(value.toString(), keymap)
                if (min == 0) {
                    totalNumberOfClicks = -1
                    break
                }
                totalNumberOfClicks += min
            }
            answer.add(totalNumberOfClicks)

        }
        return answer.toIntArray()
    }

    private fun findTheLeastNumber(key: String, keymap: Array<String>): Int {
        var result = mutableListOf<Int>()
        keymap.forEach { board ->
            var numberOfClicks = board.indexOf(key) + 1
            if (numberOfClicks == 0) {
                numberOfClicks = 100
            }
            result.add(numberOfClicks)
        }
        result.sort()
        if (checkAllZero(result)) return 0
        else return result[0]
    }

    private fun checkAllZero(list: MutableList<Int>): Boolean {
        return list.all { it == 100 }
    }
}

fun main() {
    println(
        programmers_0525().solution(
            arrayOf("BC"),
            arrayOf("AC","BC")
        ).toList()
    )

//    println(
//        programmers_0525().solution(
//            arrayOf("AA", "B"),
//            arrayOf("ABCD","AABB")
//        ).toList()
//    )
//
//    println(
//        programmers_0525().solution(
//            arrayOf("AGZ", "BSSS"),
//            arrayOf("ASA","BGZ")
//        ).toList()
//    )
}