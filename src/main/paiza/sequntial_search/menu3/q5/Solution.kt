package sequntial_search.menu3.q5

fun main() {
    val coordinatesNum = readln().toInt()
    val coordinates = List(coordinatesNum) {
        readln().split(" ").let { Pair(it[0].toInt(), it[1].toInt()) }
    }
    val k = readln().toInt()
    val n = coordinates.last()

    var count = 0

    coordinates.forEach {
        if (getManhattanDistance(it, n) <= k) {
            count ++
        }
    }

    println(count)
}

fun getManhattanDistance(target: Pair<Int, Int>, n: Pair<Int, Int>): Int {
    return Math.abs(target.first - n.first) + Math.abs(target.second - n.second)
}