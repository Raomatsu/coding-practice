package sequntial_search.menu1.q1

fun main() {
    readln()
    val numList = readln().split(" ").map { it.toInt() }
    val target = readln().toInt()
    println(numList.filter { it == target }.size)
}