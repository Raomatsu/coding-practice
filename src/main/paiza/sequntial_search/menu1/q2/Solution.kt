package sequntial_search.menu1.q2

fun main() {
    readln()
    val numList = readln().split(" ").map { it.toInt() }
    val target = readln().toInt()

    var result = 0
    for ((index, value) in numList.withIndex()) {
        if (value == target) {
            result = index + 1
            break
        }
    }
    println(result)
}