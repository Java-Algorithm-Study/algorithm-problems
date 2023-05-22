package main.kotlin.programmers.implement

/**
 * 달리는 경주
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
fun solution(players: Array<String>, callings: Array<String>): Array<String> {
    var map =  mutableMapOf<String, Int>()
    players.forEachIndexed { index, s -> map[s] = index }

    callings.forEach {
        val rank = map[it]!!
        val frontPlayer = players[rank-1]
        map[frontPlayer] = rank

        players[rank] = frontPlayer
        map[it] = rank.minus(1)
        players[rank.minus(1)] = it
    }

    return players.toList().toTypedArray()
}

fun main() {
    println(
        solution(
            arrayOf("mumu", "soe", "poe", "kai", "mine"),
            arrayOf("kai", "kai", "mine", "mine")
        )
    )
}