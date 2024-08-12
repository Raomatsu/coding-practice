package sequntial_search.menu3.q4

fun main() {
    val listSize = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val k = readln().toInt()

    var result = Int.MIN_VALUE

    for(index in 0 until listSize) {
        if (list[index] in result .. k) {
            result = list[index]
        }
    }

    println(result)
}