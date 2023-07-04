package main.kotlin

fun String.toAssetResult(): Asset =
    when {
        length != 9 -> throw ValidationError
        slice(0..1).toIntOrNull() == null -> throw ValidationError
        get(2) != '-' -> throw ValidationError
        runCatching { Asset.Type.valueOf(slice(3..4)) }.isFailure -> throw ValidationError
        slice(5..6).toIntOrNull() == null -> throw ValidationError
        slice(7..8).toIntOrNull() == null -> throw ValidationError
        else -> Asset(
            text = this,
            yy = slice(0..1).toInt(),
            type = Asset.Type.valueOf(slice(3..4)),
            mm = slice(5..6).toInt(),
            no = slice(7..8).toInt()
        )
    }

class Solution {
    fun solution(assets: Array<String>): Array<String> =
        assets.mapNotNull { asset -> runCatching { asset.toAssetResult() }.getOrNull() }
            .sorted()
            .filter(Asset::isValid)
            .map(Asset::text)
            .distinct()
            .toTypedArray()

}

object ValidationError : Throwable()

data class Asset(
    val text: String,
    val yy: Int,
    val type: Type,
    val mm: Int,
    val no: Int
) : Comparable<Asset> {

    enum class Type {
        SP, KE, MO, CO, DE
    }

    val isValid: Boolean
        get() {
            return (yy in 13..22) && (mm in 1..12) && when {
                yy == 13 && mm < 4 -> false
                yy == 22 && mm > 8 -> false
                else -> true
            } && (no in 1..99)
        }

    override fun compareTo(other: Asset): Int {
        return when {
            yy > other.yy -> 1
            yy < other.yy -> -1
            type.ordinal > other.type.ordinal -> 1
            type.ordinal < other.type.ordinal -> -1
            mm > other.mm -> 1
            mm < other.mm -> -1
            no > other.no -> 1
            no < other.no -> -1
            else -> 0
        }
    }

}
