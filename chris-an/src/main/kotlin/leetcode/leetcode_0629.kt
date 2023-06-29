package main.kotlin.leetcode


/**
 * Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 */
class leetcode_0629 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val hash = HashMap<String, MutableList<String>>()
        strs.forEach {
            val key = it.toList().sorted().joinToString("")

            val selectHash = hash[key] ?: mutableListOf()
            selectHash.add(it)
            hash[key] = selectHash
        }

        return hash.values.toList()
    }
}

fun main() {
    println(
        leetcode_0629().groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
    )
}