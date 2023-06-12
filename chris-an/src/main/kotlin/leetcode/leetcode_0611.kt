package main.kotlin.leetcode

/**
 * Problem => Confusing Number
 * 10의 자리수로 index search를 통해서 푼다면 시간복잡도, 공간복잡도가 좋아질 수 있다.
 * hashMap 을 통해 푼다면, 공간복잡도 시간복잡도 둘 다 줄일 수 있다.
 * 데이터를 비교하기 위해서 list 자료구조를 이용하여 값을 저장하는 방법을 다른 식으로 해결할 수 있다면 공간복잡도를 줄일 수 있을 것이다.
 *
 * Character.getNumericValue : Char to Int Convert
 */
class leetcode_0611 {
    fun confusingNumber(n: Int): Boolean {
        val memory = mutableListOf<Int>()
        val number = n.toString()
        val confusedNumber = n.toString().reversed()
        for (each in confusedNumber) {
            var num = Character.getNumericValue(each)
            if (num == 2 || num == 3 || num == 4 ||
                    num == 5 || num == 7) {
                return false
            }
            if (num == 6) num = 9
            else if (num == 9) num = 6

            memory.add(num)
        }

        return number != memory.joinToString("")
    }
}

fun main() {
    println(
            leetcode_0611().confusingNumber(36189)
    )
    println(
            leetcode_0611().confusingNumber(88)
    )
    println(
            leetcode_0611().confusingNumber(96)
    )
    println(
            leetcode_0611().confusingNumber(916)
    )
    println(
            leetcode_0611().confusingNumber(10089)
    )
}