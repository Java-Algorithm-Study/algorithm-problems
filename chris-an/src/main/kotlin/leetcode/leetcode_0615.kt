package main.kotlin.leetcode

class leetcode_0615 {
    fun reverseWords(s: CharArray): Unit {
        val joinString:String  = s.joinToString("")
        val array = joinString.split(" ")
        var index = 0
        (array.reversed()).toMutableList().forEach {
            for (each in it.toCharArray()) {
                s[index++] = each
            }
            if (index < s.size) {
                s[index++] = ' '
            }
        }
    }
}

fun main() {
    println(
        leetcode_0615().reverseWords(
            charArrayOf('t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e')
        )
    )
}