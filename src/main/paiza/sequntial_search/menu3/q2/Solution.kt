package sequntial_search.menu3.q2

fun main() {
//    var lastIndexOfOddNum = 0
//    readln()
//    readln().split(" ").map { it.toInt() }.forEachIndexed { index, value ->
//        if (value % 2 != 0) {
//            lastIndexOfOddNum = index + 1
//        }
//    }
//    println(lastIndexOfOddNum)

    /**
     * 別解
     */
    // リストを反転させて、最初に登場した奇数を返す
    readln()
    val numList = readln().split(" ").map { it.toInt() }
    val reverseNumList = numList.mapIndexed { index, value->
        numList[(numList.size-1) - index]
    }
    for((index, value) in reverseNumList.withIndex()) {
        if (value % 2 != 0) {
            println((reverseNumList.size - 1) - (index) + 1)
            break
        }
    }
}

