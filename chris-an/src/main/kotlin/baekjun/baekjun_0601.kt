package main.kotlin.baekjun

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


class Nation(
    val name: Int,
    val gold: Int,
    val silver: Int,
    val bronze: Int
) : Comparable<Nation> {
    override fun compareTo(other: Nation): Int {
        if (this.gold == other.gold) {
            if (this.silver == other.silver) {
                return other.bronze - this.bronze;
            } else return other.silver - this.silver;
        } else
            return other.gold - this.gold;
    }

    override fun toString(): String {
        return "Nation(name=$name, gold=$gold, silver=$silver, bronze=$bronze)"
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val t = st.nextToken().toInt()

    val list = ArrayList<Nation>()

    for (i in 0 until n) {
        val input = StringTokenizer(br.readLine())
        val num = input.nextToken().toInt()
        val gold = input.nextToken().toInt()
        val silver = input.nextToken().toInt()
        val bronze = input.nextToken().toInt()

        list.add(Nation(num, gold, silver, bronze))
    }

    list.sort()

    var index = 0
    for(i in list.indices) {
        if (list[i].name === t) {
            index = i
            break
        }
    }

    var rate = 1
    var cnt = 1
    for (i in 1 until n) {
        val prev = list[i - 1]
        val cur = list[i]
        if (prev.gold != cur.gold ||
            prev.silver != cur.silver ||
            prev.bronze != cur.bronze) {
            rate += cnt
            cnt = 1
        } else cnt++

        if (cur.name === t) {
            println(rate)
            break
        }
    }
}