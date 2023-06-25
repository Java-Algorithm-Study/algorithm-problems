package main.kotlin.leetcode

import java.util.Stack

/**
 * Buildings With an Ocean View
 * https://leetcode.com/problems/buildings-with-an-ocean-view/description/
 *
 * ArrayDeque
 * LinkedList
 * Stack
 * 등.. 다양한 자료구조 사용 가능
 */

class leetcode_0620_2 {

    fun findBuildings(heights: IntArray): IntArray {
        var stack: Stack<Int> = Stack<Int>()
        heights.forEachIndexed { index, height ->
            while(stack.isNotEmpty() && heights[stack.peek()] <= height) {
                stack.pop()
            }
            stack.push(index)
        }
        return stack.toIntArray()
    }
}

fun main() {
    println(
        leetcode_0620_2().findBuildings(
            intArrayOf(4,3,2,1)
        )
    )
}