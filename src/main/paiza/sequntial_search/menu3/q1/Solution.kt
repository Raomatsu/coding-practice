package sequntial_search.menu3.q1

fun main() {
    val size = readln().toInt()
    val numList = readln().split(" ").map { it.toInt() }

    for(index in 0 until size) {
        if (numList[index] % 2 == 0) {
            println(index + 1)
            break
        }
    }
}