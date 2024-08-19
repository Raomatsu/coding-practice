package main.paiza.sort.select

fun main() {
    val size = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()

//    for(left in 0 .. list.lastIndex) {
//        for (i in left .. list.lastIndex) {
//            if (list[i] < list[left]) {
//                val temp = list[i]
//                list[i] = list[left]
//                list[left] = temp
//            }
//        }
//        println(list.joinToString(" "))
//    }
    for(left in 0 until list.lastIndex) {
        var minValueIndex = left
        for (i in left + 1 .. list.lastIndex) {
            if (list[i] < list[minValueIndex]) {
                minValueIndex = i
            }
        }
        val temp = list[left]
        list[left] = list[minValueIndex]
        list[minValueIndex] = temp

        println(list.joinToString(" "))
    }
}