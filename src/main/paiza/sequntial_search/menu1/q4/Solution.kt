package sequntial_search.menu1.q4

fun main() {
    readln()
    val numList = readln().split(" ").map { it.toInt() }
    val target = readln().toInt()

    for ((index, value) in numList.withIndex()) {
        if (value == target) {
            println(index + 1)
        }
    }
}