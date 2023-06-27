package main.kotlin.leetcode

/**
 * Insert Delete GetRandom O(1)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 */
class leetcode_0627 {
}
class RandomizedSet() {
    val hash = HashMap<Int, Int>()
    fun insert(`val`: Int): Boolean {
        hash[`val`] = (hash[`val`] ?: 0) + 1
        if(hash[`val`] ?: 0 > 1) {
            hash[`val`] = 1
            return false
        }
        return true
    }

    fun remove(`val`: Int): Boolean {
        if(hash.containsKey(`val`)) {
            hash.remove(`val`)
            return true
        } else{
            return false
        }
    }

    fun getRandom(): Int {
        val list = hash.keys.toList()
        val range = (0 .. list.size-1)
        val index = range.random()
        return list[index]
    }
}