package main.kotlin.leetcode


/**
 * 1. 길이가 같아야 한다.
 * 2. 단어가 같아야 한다.
 * 3. similarPairs 에서 지정한 값이라면 같다고 볼 수 있다.
 *
 * Sentence Similarity
 * https://leetcode.com/problems/sentence-similarity/description/?envType=study-plan-v2&envId=premium-algo-100
 */
class leetcode_0618 {
    fun areSentencesSimilar(sentence1: Array<String>, sentence2: Array<String>, similarPairs: List<List<String>>): Boolean {
        // 1.
        if (sentence1.size != sentence2.size) return false
        // 2, 3 둘 다 처리
        val map = HashMap<String, MutableList<String>>()
        similarPairs.forEach { pair ->

            val list = map[pair[0]] ?: mutableListOf()
            list.add(pair[1])
            map[pair[0]] = list
        }

        for (i in sentence1.indices) {
            val word1 = sentence1[i]
            val word2 = sentence2[i]
            if (word1 == word2) continue
            if (map.containsKey(word1)) {
                val list = map[word1] ?: mutableListOf()
                if (list.contains(word2)) continue
            }
            if (map.containsKey(sentence2[i])) {
                val list = map[word2] ?: mutableListOf()
                if (list.contains(word1)) continue
            }
            return false
        }

        return true
    }
}

fun main() {
    println(
        leetcode_0618().areSentencesSimilar(
            arrayOf("great","acting","skills"),
            arrayOf("fine","drama","talent"),
            listOf(
                listOf("great","fine"),
                listOf("drama","acting"),
                listOf("skills","talent")
            )
        )
    )

    println(
        leetcode_0618().areSentencesSimilar(
            arrayOf("great"),
            arrayOf("doubleplus","good"),
            listOf(
                listOf("great","doubleplus")
            )
        )
    )
}