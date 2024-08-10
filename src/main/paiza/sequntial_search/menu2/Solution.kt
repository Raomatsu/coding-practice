package sequntial_search.menu2

fun main() {
//    readln()
    val numList = readln().split(" ").map { it.toInt() }
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    numList.forEach {
        if (it < min) min = it
        if (it > max) max = it
    }
    println("$max $min")
}