package main.kotlin.leetcode



/**
 * Maximum Ice Cream Bars
 * https://leetcode.com/problems/maximum-ice-cream-bars/description/
 */
class leetcode_0620 {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        costs.sort()
        var costSum = 0

        for (i in costs.indices) {
            if (costSum + costs[i] > coins)
                return i
            costSum += costs[i]
        }

        return costs.size
    }

    fun maxIceCream_time_best(costs: IntArray, coins: Int): Int {
        // the second way through counting sorting after reading about it

        var count = 0
        var remainingCoins = coins

        val array = IntArray(costs.max()!! + 1).apply {
            for (i in costs) {
                this[i] += 1
            }
        }

        for (i in 0 until array.size) {
            if (array[i] == 0) continue
            if (remainingCoins < i) break

            val available = Math.min(array[i], remainingCoins / i)
            remainingCoins -= i * available
            count += available
        }

        return count
    }
}

fun main() {
    println(
        leetcode_0620().maxIceCream(
            intArrayOf(10,6,8,7,7,8),
            5
        )
    )

    println(
        leetcode_0620().maxIceCream(
            intArrayOf(1,6,3,1,2,5),
            20
        )
    )

    println(
        leetcode_0620().maxIceCream(
            intArrayOf(1,3,2,4,1),
            7
        )
    )
}