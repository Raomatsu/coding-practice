package sequntial_search.menu3.q6

fun main() {
    val n = readln().toInt()
    val coordinates = List(n) {
        readln().split(" ").let { Pair(it[0].toInt(), it[1].toInt()) }
    }

    val (xs, xt) = readln().split(" ").map { it.toInt() }
    val (ys, yt) = readln().split(" ").map { it.toInt() }
    val square = Square(xs, xt, ys, yt)

    var count = 0
    coordinates.forEach { if (square.include(it)) count++ }
    print(count)
}

/**
 * xs < xt
 * ys < yt
 */
data class Square(
    val xs: Int,
    val xt: Int,
    val ys: Int,
    val yt: Int,
) {
    fun include(coordinate: Pair<Int, Int>): Boolean {
        return coordinate.first in xs .. xt && coordinate.second in ys .. yt
    }
}

