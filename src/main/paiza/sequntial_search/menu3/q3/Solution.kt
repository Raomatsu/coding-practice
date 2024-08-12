package sequntial_search.menu3.q3

fun main() {
    val listSize = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val k = readln().toInt()

    var result = Int.MAX_VALUE

    for(index in 0 until listSize) {
        if (list[index] in k until result) {
            result = list[index]
        }
    }

    println(result)
}