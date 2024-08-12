package sequntial_search.menu4.q1

fun main() {
    readln()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()
//    // バブルソートを手動実装
//    for (i in 0 until list.size - 1) {
//        for (j in list.size - 1 downTo  i + 1) {
//            if (list[j] < list[j-1]) {
//                val temp = list[j]
//                list[j] = list[j-1]
//                list[j-1] = temp
//            }
//        }
//    }
//    println(list[list.size - 2])
    /**
     * 別解
     * 最大値より1つ小さいやつを出力
     */
    var max = Int.MIN_VALUE
    list.forEach { if (it > max) max = it }

    var nextMax = Int.MIN_VALUE
    list.forEach { if (it in (nextMax + 1) until max) nextMax = it }
    println(nextMax)
}
