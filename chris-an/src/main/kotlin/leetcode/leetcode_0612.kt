package main.kotlin.leetcode

class leetcode_0612 {
    fun stringShift_1(s: String, shift: Array<IntArray>): String {
        var result = s

        for (command in shift) {
            val direction = command[0]
            val count = command[1]

            repeat(count) {
                if (direction == 0) result = leftShift(result)
                else result = rightShift(result)
            }
        }

        return result
    }

    private fun rightShift(result: String): String {
        val lastChar = result[result.length-1]

        return (lastChar + result).substring(0, result.length)
    }

    private fun leftShift(result: String): String {
        val firstChar = result[0]

        return (result + firstChar).substring(1, result.length + 1)
    }

    fun stringShift_2(s: String, shift: Array<IntArray>): String {
        var shiftCount = 0
        shift.forEach {
            shiftCount += if (it[0] == 0) it[1] else -it[1]
        }

        shiftCount %= s.length

        if (shiftCount < 0) {
            shiftCount += s.length
        }

        return s.substring(shiftCount) + s.substring(0, shiftCount)
    }

}

fun main() {
    println(
            leetcode_0612().stringShift_2(
                    "abcdefg",
                    arrayOf(
                            intArrayOf(1,1),
                            intArrayOf(1,1),
                            intArrayOf(0,2),
                            intArrayOf(1,3)
                    )
            )
    )
}