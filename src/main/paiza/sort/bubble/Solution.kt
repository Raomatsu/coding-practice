package main.paiza.sort.bubble

fun main() {
    val size = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()

    for (left in 0 until list.lastIndex) {
        for (i in list.lastIndex downTo left + 1) {
            if (list[i] < list[i - 1]) {
                val temp = list[i]
                list[i] = list[i - 1]
                list[i - 1] = temp
            }
        }
        println(list.joinToString(" "))
    }
}