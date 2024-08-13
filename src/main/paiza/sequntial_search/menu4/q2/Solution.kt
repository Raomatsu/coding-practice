package sequntial_search.menu4.q2

fun main() {
    readln()
    val list = readln().split(" ").map { it.toInt() }
    val k = readln().toInt()
    val sortedList = getSorted(list)

    println(sortedList[sortedList.size - k])
}

fun getSorted(list: List<Int>): List<Int> {
    val mutableList = list.toMutableList()
    for (i in 0 until mutableList.lastIndex) {
        for (j in mutableList.lastIndex downTo i + 1) {
            if (mutableList[j] < mutableList[j - 1]) {
                val temp = mutableList[j]
                mutableList[j] = mutableList[j - 1]
                mutableList[j - 1] = temp
            }
        }
    }
    return mutableList.toList()
}
